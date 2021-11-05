package com.letsmakeadeal.client;


import com.letsmakeadeal.Display;
import com.letsmakeadeal.Reward;
import com.letsmakeadeal.User;

import java.util.Scanner;

class Host {

    // ---- FIELDS ----
    private Display display;//host has-a display
    private User user; //host has-a user
    private boolean isPlaying = true;
    Scanner scanner = new Scanner(System.in);

    // ---- CONSTRUCTORS ----

    Host() {
        this.display = new Display();
        this.user = new User();
    }


    // ---- BUSINESS METHODS ----

    public void execute() {
        greetUser();
//        showMenu();
        startGame(); //initialize user with default reward (user.setReward)
        while (isPlaying) {
//          displayStage(); //update of rewards done here
          makeOffer();
//          showResults();
        }
        endGame();
    }

    private void endGame() {
        System.out.println("EndGame as been called by the Host");
    }

    public void makeOffer() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Would you like to choose another prize?");
            System.out.println(" [Y]es [N]o");
            String choice = scanner.nextLine();
            if (choice.toUpperCase().equals("Y")) {
                System.out.println("You will choose again!");
//                promptUserForChoice();

                validInput = true;
            } else if (choice.toUpperCase().equals("N")) {
                System.out.println("Thanks for playing!");
                this.isPlaying = false;
                validInput = true;
            }
        }
    }

    public Reward getRewardFromDisplay() {
        /*
         * return display.getRandomReward();
         */
        return null;
    }

    private void startGame() {
        System.out.println("user.setReward will be called from within Host.It will pass into it a randomized reward from the display");
        /*
         * Reward reward = getRewardFromDisplay();
         * user.setRewards(reward) //sets initial reward for the user
         *
         *
         */
    }

    private void greetUser() {
        System.out.println();
        System.out.println();
        System.out.println("- - - - L E T ' S    M A K E    A    D E A L - - - -");
        System.out.println();
        System.out.println("Welcome! Let's Make A Deal!");
    }

    private void showMenu(){
        //start game menu
    }

    // ---- GETTERS - SETTERS ----


}
