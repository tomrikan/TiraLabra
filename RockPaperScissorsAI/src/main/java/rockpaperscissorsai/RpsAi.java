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
    private ArrayList<Integer> moves;
    private int lastOppMove;
    private int oppMoveBeforeLast;

    /**
     * Constructor.
     */
    public RpsAi() {
        this.score = 0;
        this.timesOppPlayedMove = new int[]{0, 0, 0}; //rock, paper, scissors
        this.markov = new float[][]{{0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}};
        this.moves = new ArrayList<>();
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
     * Take opponent's previous move and update markov chain and move list.
     * @param move opponent's move.
     */
    public void updateData(String move) {

        this.oppMoveBeforeLast = this.lastOppMove;
        //determine opp's last move and add it to the list.
        if (move.equals("R")) {
            this.lastOppMove = 0;
            moves.add(0);
        } else if (move.equals("P")) {
            this.lastOppMove = 1;
            moves.add(1);
        } else {
            this.lastOppMove = 2;
            moves.add(2);
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
        return this.moves;
    }
    
    public float[][] getMarkov() {
        return this.markov;
    }
}
