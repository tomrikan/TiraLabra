/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsai;

import java.util.Random;


/**
 * Class for AI functions.
 *
 * @author tomi
 */
public class RpsAi {

    private int score;

    public RpsAi() {
        this.score = 0;
    }

    /*
     * Create AI and get it's move.
     */
    public String getMove() {
        // Quick random solution to get the game functioning
        int moveInt;
        Random rnd = new Random();
        moveInt = rnd.nextInt(3-1+1)+1;

        if (moveInt == 1) {
            return "ROCK";
        } else if (moveInt == 2) {
            return "PAPER";
        } else {
            return "SCISSORS";
        }
    }

    public int getScore() {
        return this.score;
    }

    public void raiseScore() {
        this.score++;
    }

}
