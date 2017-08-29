/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsai;

import java.util.Scanner;

/**
 * Class contains user interface and game logic.
 * These should be actually in different classes
 * but for this simple game and purpose of programming AI
 * they are in same class this time.
 * @author tomi
 */
public class Game {

    /**
     * Launch gameloop according to user's choice.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Rock-Paper-Scissors against AI");
        System.out.println("1. Player VS AI");
        System.out.println("2. AI VS AI for 1000 rounds");
        String option = "";

        while (!option.equals("1") || !option.equals("2")) {
            option = scanner.nextLine();

            if (option.equals("1")) {
                gameLoop(scanner);
                break;
            } else if (option.equals("2")) {
                gameLoopAi();
                break;
            } else {
                System.out.println("Give legit input.");
            }
        }
    }

    /**
     * Determine who wins the round.
     *
     * @param playerMove player's move.
     * @param aiMove AI's move.
     * @return winner as integer.
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

    /**
     * Basic gameloop for human vs AI.
     * @param scanner as Scanner.
     */
    public static void gameLoop(Scanner scanner) {
        Player player = new Player();
        RpsAi ai = new RpsAi();

        boolean quit = false;
        int winner;

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
                ai.raiseLooses();
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
     * Gameloop for AI vs AI, namely itself.
     */
    public static void gameLoopAi() {
        RpsAi aiFirst = new RpsAi();
        RpsAi aiSecond = new RpsAi();

        int winner;

        for (int i = 0; i < 1000; i++) {
            String aiFirstMove = aiFirst.getMove();
            String aiSecondMove = aiSecond.getMove();

            System.out.println("AI_1: " + aiFirstMove + " | AI_2: " + aiSecondMove);

            winner = roundWinner(aiFirstMove, aiSecondMove);
            if (winner == 1) {
                System.out.println("AI_2 wins.");
                aiSecond.raiseScore();
                aiFirst.raiseLooses();
            } else if (winner == -1) {
                System.out.println("AI_1 wins.");
                aiFirst.raiseScore();
                aiSecond.raiseLooses();
            } else {
                System.out.println("It's a tie.");
            }
            aiFirst.updateData(aiSecondMove);
            aiSecond.updateData(aiFirstMove);

            System.out.println("AI_1: " + aiFirst.getScore() + " | AI_2: "
                    + aiSecond.getScore());
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Game has ended, final scores:");
        System.out.println("AI_1: " + aiFirst.getScore());
        System.out.println("AI_2: " + aiSecond.getScore());
    }
}