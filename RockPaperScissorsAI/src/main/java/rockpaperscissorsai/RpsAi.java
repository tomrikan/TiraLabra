/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsai;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class for AI functions.
 *
 * @author tomi
 */
public class RpsAi {

    private int score;
    private int[] timesOppPlayedMove;
    private float[][] markov;
    private DynamicArray oppMoves;
    private int lastOppMove;
    private int oppMoveBeforeLast;
    private int roundsPlayed;
    private int loosesInRow;

    /**
     * Constructor.
     */
    public RpsAi() {
        this.score = 0;
        this.timesOppPlayedMove = new int[]{0, 0, 0}; //rock, paper, scissors
        this.markov = new float[][]{{0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}};
        this.roundsPlayed = 0;
        this.loosesInRow = 0;
        this.oppMoves = new DynamicArray();
    }

    /**
     * Get AI's move. Uses three private sub methods.
     *
     * @return AI's move as String.
     */
    public String getMove() {

        //if getting lot of loses throw in random.
        if (this.loosesInRow > 3) {
            return getRandomMove();
        }

        //quick solution, every second move based on history after 40 rounds, otherwise on markov.
        if (this.roundsPlayed > 40 && this.roundsPlayed % 2 == 0) {
            int move = historySeek(3);
            return getHistoryBasedMove(move);
        } else {
            return getMarkovBasedMove();
        }
    }

    private String getHistoryBasedMove(int move) {
        //Return opposite of what is predicted.
        if (move == 0) {
            return "P";
        } else if (move == 1) {
            return "S";
        } else {
            return "R";
        }
    }

    /**
     * Returns move based on markov chain.
     *
     * @return AI's move as string.
     */
    public String getMarkovBasedMove() {
        float rndFloat;
        Random rnd = new Random();
        rndFloat = rnd.nextFloat();

        //return opposite of what is predicted
        if (rndFloat <= this.markov[this.lastOppMove][1]) {
            return "S";
        } else if (rndFloat <= this.markov[this.lastOppMove][2] + markov[this.lastOppMove][1]) { //check probability space
            return "R";
        } else {
            return "P";
        }
    }

    /**
     * Get random based move.
     *
     * @return AI's move as string.
     */
    public String getRandomMove() {
        int rndInt;
        Random rnd = new Random();
        rndInt = rnd.nextInt(3);

        if (rndInt == 0) {
            return "R";
        } else if (rndInt == 1) {
            return "P";
        } else {
            return "S";
        }
    }

    /**
     * Check move history and return the move that opponent would most likely
     * play based on the history. This is done by checking what player chose most
     * often after certain sequence (last n moves) in move history.
     * @param n as length of sequence to be checked.
     * @return move as integer.
     */
    public int historySeek(int n) {

        int[] sequence = new int[n];
        int[] timesPlayed = new int[]{0, 0, 0};

        for (int i = 0; i < n; i++) {
            sequence[i] = oppMoves.get(oppMoves.size() - n + i);
        }

        for (int i = 0; i < oppMoves.size() - n; i++) {
            if (oppMoves.get(i) == sequence[0]) {
                for (int j = 0; j < n; j++) {
                    if (sequence[j] != oppMoves.get(i + j)) {
                        break;
                    }
                    if (j == sequence.length - 1) {
                        timesPlayed[oppMoves.get(i + j + 1)]++;
                    }
                }
            }
        }
        int move = biggest(timesPlayed);
        return move;
    }

    /**
     * Return biggest number out of array.
     * @param timesPlayed array of moves and how many times each played.
     * @return biggest move as integer.
     */
    private int biggest(int[] timesPlayed) {
        int biggest = timesPlayed[0];
        int move = 0;

        if (timesPlayed[1] > biggest) {
            biggest = timesPlayed[1];
            move = 1;
        }
        if (timesPlayed[2] > biggest) {
            move = 2;
        }
        return move;
    }

    /**
     * Take opponent's previous move and update markov chain and move list.
     *
     * @param move opponent's move as String.
     */
    public void updateData(String move) {
        this.roundsPlayed++;

        this.oppMoveBeforeLast = this.lastOppMove;
        //determine opp's last move and add it to the list.
        if (move.equals("R")) {
            this.lastOppMove = 0;
            oppMoves.add(0);
        } else if (move.equals("P")) {
            this.lastOppMove = 1;
            oppMoves.add(1);
        } else {
            this.lastOppMove = 2;
            oppMoves.add(2);
        }
        //update markov chain
        for (int i = 0; i < 3; i++) {
            this.markov[this.oppMoveBeforeLast][i] *= this.timesOppPlayedMove[this.oppMoveBeforeLast];
        }
        this.markov[this.oppMoveBeforeLast][this.lastOppMove]++;
        this.timesOppPlayedMove[this.oppMoveBeforeLast]++;
        for (int i = 0; i < 3; i++) {
            this.markov[this.oppMoveBeforeLast][i] /= this.timesOppPlayedMove[this.oppMoveBeforeLast];
        }
    }

    public int getScore() {
        return this.score;
    }

    /**
     * Raise AI's score.
     */
    public void raiseScore() {
        this.score++;
        this.loosesInRow = 0;
    }

    public void raiseLooses() {
        this.loosesInRow++;
    }

    public DynamicArray getMoves() {
        return this.oppMoves;
    }

    public float[][] getMarkov() {
        return this.markov;
    }

    public int getRoundsPlayed() {
        return this.roundsPlayed;
    }
}