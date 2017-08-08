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

    public RpsAi() {
        this.score = 0;
        this.timesOppPlayedMove = new int[]{0, 0, 0}; //rock, paper, scissors
        this.markov = new float[][]{{0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}};
        this.moves = new ArrayList<>();
    }

    /*
     * Get AI's move. TODO: Get move based on which works better, markov or move history.
     * Keep count which one is/would be performing better and choose accordingly.
     */
    public String getMove() {

        float rndFloat;
        Random rnd = new Random();
        rndFloat = rnd.nextFloat();
        
        //return opposite of what is predicted
        if (rndFloat <= this.markov[this.lastOppMove][1]) {
            return "SCISSORS";
        } else if (rndFloat <= this.markov[this.lastOppMove][2] + markov[this.lastOppMove][1]) {
            return "ROCK";
        } else {
            return "PAPER";
        }
    }

    /*
     * Take opponent's previous move and update markov chain and move list.
     */
    public void updateData(String move) {

        this.oppMoveBeforeLast = this.lastOppMove;
        if (move.equals("ROCK")) {
            this.lastOppMove = 0;
        } else if (move.equals("PAPER")) {
            this.lastOppMove = 1;
        } else {
            this.lastOppMove = 2;
        }

        for (int i = 0; i < 3; i++) { //1.
            this.markov[this.oppMoveBeforeLast][i] *= this.timesOppPlayedMove[this.oppMoveBeforeLast];
        }

        this.markov[this.oppMoveBeforeLast][this.lastOppMove] += 1;

        this.timesOppPlayedMove[this.oppMoveBeforeLast]++;

        for (int i = 0; i < 3; i++) {
            this.markov[this.oppMoveBeforeLast][i] /= this.timesOppPlayedMove[this.oppMoveBeforeLast];
        }
    }

    public int getScore() {
        return this.score;
    }

    public void raiseScore() {
        this.score++;
    }

}
