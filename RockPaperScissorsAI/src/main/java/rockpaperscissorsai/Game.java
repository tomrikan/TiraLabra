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

    /**
     * Create the game loop and basic functions. Take input from player and ai.
     * Repeat until user chooses to quit. AI takes in player's move.
     */
    public static void main(String[] args) {
        boolean quit = false;
        Player player = new Player();
        RpsAi ai = new RpsAi();
        int winner;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rock-Paper-Scissors against AI");
        System.out.println("");

        while (!quit) {

            String playerMove = "";
            while (!player.checkMove(playerMove)) {
                System.out.println("Enter your move (r, p, s or quit): ");
                playerMove = scanner.nextLine().toUpperCase();
            }
            System.out.println("");
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
            ai.updateData(playerMove);

            System.out.println("Player: " + player.getScore() + " | Computer: "
                    + ai.getScore());
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Game has ended, final scores:");
        System.out.println("Player: " + player.getScore());
        System.out.println("Computer: " + ai.getScore());
    }

    /**
     * Determine who wins the round.
     *
     * @param playerMove player's move.
     * @param aiMove AI's move.
     * @return winner.
     */
    static int roundWinner(String playerMove, String aiMove) {
        int winner;

        if (aiMove.equals(playerMove)) {
            winner = 0;
        } else if (aiMove.equals("R")
                && playerMove.equals("S")) {
            winner = 1;
        } else if (aiMove.equals("P")
                && playerMove.equals("R")) {
            winner = 1;
        } else if (aiMove.equals("S")
                && playerMove.equals("P")) {
            winner = 1;
        } else {
            winner = -1;
        }
        return winner;
    }
}
