/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsai;

import java.util.Scanner;

/**
 *
 * @author tomi
 */
public class Game {

    public static void main(String[] args) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        RpsAi ai = new RpsAi();

        System.out.println("Rock, Paper, Scissors against AI");
        System.out.println("");

        while (quit == false) {

            System.out.println("What would you like to do?");
            System.out.println("1. Play");
            System.out.println("2. Exit");
            System.out.print("Enter numeric value: ");

            int input = scanner.nextInt();

            if (input == 1) {
                play();
                break;
            }
            if (input == 2) {
                System.out.println("Thank you for playing");
                quit = true;
            } else {
                System.out.println("");
                System.out.println("Invalid input.");
                System.out.println("");
            }
        }

    }
    /**
     * Create the gameloop
     */
    public static void play() {
        boolean play = true;
        
    }

}
