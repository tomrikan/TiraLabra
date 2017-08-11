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

    private Scanner scanner;
    private int score;
    
    /**
     * Constructor.
     */
    public Player() {
        this.scanner = new Scanner(System.in);
        this.score = 0;
    }

    /**
     * Read in user move. Prompt until valid move is entered. Valid moves are
     * rock, paper and scissors.
     *
     * @return user's move as rock, paper or scissors.
     */
    public String getMove() {
        String move = "";

        while (!move.equals("ROCK")
                && !move.equals("PAPER")
                && !move.equals("SCISSORS")
                && !move.equals("QUIT")) {
            System.out.print("Enter your move (rock, paper, scissors,(quit for quitting)): ");
            move = scanner.nextLine().toUpperCase();
        }
        return move;
    }
    
    /**
     * Get player's score.
     * @return score.
     */
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