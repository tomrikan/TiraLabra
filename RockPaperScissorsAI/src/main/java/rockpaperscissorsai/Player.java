/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsai;

import java.util.Scanner;

/**
 * Class for player's functions.
 *
 * @author tomi
 */
public class Player {

    private int score;

    /**
     * Constructor.
     */
    public Player() {
        this.score = 0;
    }

    /**
     * Check user move. Valid moves are
     * rock, paper and scissors.
     *
     * @return true if valid, false if not.
     */
    public Boolean checkMove(String move) {

        if (move.equals("R") || move.equals("P") || move.equals("S")
                || move.equals("QUIT")) {
            return true;
        }
        return false;
    }

    public int getScore() {
        return this.score;
    }

    /**
     * Raise player's score.
     */
    public void raiseScore() {
        this.score++;
    }

}
