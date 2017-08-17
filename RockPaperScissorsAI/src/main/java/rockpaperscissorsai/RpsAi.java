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
    private ArrayList<Integer> oppMoves;
    private int lastOppMove;
    private int oppMoveBeforeLast;

    /**
     * Constructor.
     */
    public RpsAi() {
        this.score = 0;
        this.timesOppPlayedMove = new int[]{0, 0, 0}; //rock, paper, scissors
        this.markov = new float[][]{{0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}};
        this.oppMoves = new ArrayList<>();
    }

    /**
     * Get AI's move.
     * @return AI's move.
     */
    public String getMove() {
        //TODO: Get move based on which works better, markov or move history.
        //Keep count which one is/would be performing better and choose present strategy accordingly.

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
     * Check move history and return the move that opponent would most likely play
     * based on the history.
     * @param n
     * @return move as integer.
     */
    public int historySeek(int n) {
        //TODO: check both opp and own move sequences parallel.
        int[] sequence = new int[n];
        int[] timesPlayed = {0, 0, 0};
        
        for (int i = 0; i < n - 1; i++) {
            sequence[i] = oppMoves.get(oppMoves.size() - n + i);
        }
        
        for (int i = 0; i < oppMoves.size() - 1; i++) {
            if (oppMoves.get(i) == sequence[0]) {
                for (int j = 0; j < sequence.length - 1; j++) {
                    if (sequence[j] != oppMoves.get(i + j)) {
                        break;
                    }
                    if (j == sequence.length - 1) {
                        timesPlayed[oppMoves.get(i + j + 1)] ++;
                    }
                }
                
            }
        }
        int biggest = timesPlayed[0];
        int move = 0;
        
        if (timesPlayed[1] > biggest) {
            biggest = timesPlayed[1];
            move = 1;
        }
        if (timesPlayed[2] > biggest) {
            biggest = timesPlayed[2];
            move = 2;
        }
        
        return move;
    }

    /**
     * Take opponent's previous move and update markov chain and move list.
     * @param move opponent's move.
     */
    public void updateData(String move) {

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
        this.markov[this.oppMoveBeforeLast][this.lastOppMove] ++;
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
    }
    
    /**
     * Get move list of opponent's moves.
     * @return moves.
     */
    public ArrayList getMoves() {
        return this.oppMoves;
    }
    
    public float[][] getMarkov() {
        return this.markov;
    }
}
