/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsai;

import java.util.Scanner;

/**
 * Class contains basic game functioning.
 *
 * @author tomi
 */
public class Game {

    public static void main(String[] args) {
        boolean quit = false;
        Player player = new Player();
        RpsAi ai = new RpsAi();
        int winner;

        System.out.println("Rock-Paper-Scissors against AI");
        System.out.println("");

        /**
         * Create the game loop. Take input from player and ai. Repeat until user chooses to quit.
         */
        while (!quit) {

            String playerMove = player.getMove();
            if (playerMove.equals("QUIT")) { //quick exit function
                quit = true;
                break;
            }
            String aiMove = ai.getMove();

            System.out.println("Your move: " + playerMove + " | Computer's move: " + aiMove);

            winner = roundWinner(playerMove, aiMove);
            if (winner == 1) {
                System.out.println("The computer wins.");
                ai.raiseScore();
            } else if (winner == -1) {
                System.out.println("The player wins.");
                player.raiseScore();
            } else {
                System.out.println("It's a tie.");
            }

            System.out.println("Player: " + player.getScore() + " | Computer: "
                    + ai.getScore());
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Game has ended, final scores:");
        System.out.println("Player: " + player.getScore());
        System.out.println("Computer: " + ai.getScore());
    }

    static void dealWithWinner(int winner) {

    }

    /*
     * Determine who wins the round.
     */
    static int roundWinner(String playerMove, String aiMove) {
        int winner;

        if (aiMove.equals(playerMove)) {
            winner = 0;
        } else if (aiMove.equals("ROCK")
                && playerMove.equals("SCISSORS")) {
            winner = 1;
        } else if (aiMove.equals("PAPER")
                && playerMove.equals("ROCK")) {
            winner = 1;
        } else if (aiMove.equals("SCISSORS")
                && playerMove.equals("PAPER")) {
            winner = 1;
        } else {
            winner = -1;
        }
        return winner;
    }
}
