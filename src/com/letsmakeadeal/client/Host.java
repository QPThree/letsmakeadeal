package com.letsmakeadeal.client;


import com.letsmakeadeal.Display;
import com.letsmakeadeal.Reward;
import com.letsmakeadeal.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Host {

    // ---- FIELDS ----
    private Display display = new Display();//host has-a display
//    ArrayList<Reward> rewardsArray = new ArrayList<Reward>(List.of(Reward.values())); //refactor this to be coming from display class
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
        displayMenu();

    }

    private void showResults(Reward reward) {
        System.out.println("The reward you chose is:");
        System.out.println(reward.getName());
    }

    private void endGame() {
        System.out.println("EndGame as been called by the Host");
        System.out.println("**********************************");
        System.out.println("You final Rewards:");
        user.getRewards();
    }

    public void makeOffer() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Would you like to choose another prize?");
            System.out.println(" [Y]es [N]o");
            String choice = scanner.nextLine();

            if (choice.toUpperCase().equals("Y")) {
                Reward reward = display.getRandomReward();
                user.addReward(reward);
                showResults(reward);
                if (reward.isZonk()) {
                    this.isPlaying = false;
                    break;
                }
                System.out.println("You will choose again!");
                validInput = true;
            } else if (choice.toUpperCase().equals("N")) {
                System.out.println("Thanks for playing!");
                this.isPlaying = false;
                validInput = true;
            }
        }
    }


    private void startGame() {
        System.out.println("user.setReward will be called from within Host.It will pass into it a randomized reward from the display");

        Reward reward = display.getRandomReward(); // This  is randomized
        user.addReward(reward);                 //sets initial reward for the user

    }

    private void greetUser() {
        System.out.println();
        System.out.println();
        System.out.println("- - - - L E T ' S    M A K E    A    D E A L - - - -");
        System.out.println();
        System.out.println("Welcome! Let's Make A Deal!");
    }

    //---- from jasmine ----
    public void displayMenu() {
        boolean quit = false;
        int selection = 0;
        while (!quit) {
            System.out.println("Are you ready to make a deal?");
            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    startGame(); //initialize user with default reward (user.setReward)
                    while (isPlaying) {
                        makeOffer();
                    }
                    endGame();
                    break;
                case 2:
                quit = true;
                break;
            }
        }
    }
//    public void displayStage() {
//        int usersSelection = 0;
//        do {
//            boxChoices();
//            switch (usersSelection) {
//                case 1:
//                    System.out.println("You chose box #1 and your Reward is " + randomRewards());
//                    break;
//                case 2:
//                    System.out.println("You chose box #2 and your Reward is " + randomRewards());
//                    break;
//                case 3:
//                    System.out.println("You chose box #3 and your Reward is " + randomRewards());
//                    break;
//                case 4:
//                    System.out.println("You chose box #4 and your Reward is " + randomRewards());
//                    break;
//                case 5:
//                    System.out.println("You chose box #5 and your Reward is " + randomRewards());
//                default:
//                    break;
//            }
//        }
//    }

    public static void boxChoices() {
        System.out.println("\nPress ");
        System.out.println("\t 1 - To choose box #1");
        System.out.println("\t 2 - To choose box #2");
        System.out.println("\t 3 - To choose box #3");
        System.out.println("\t 4 - To choose box #4");
        System.out.println("\t 5 - To choose box #5");

    }
}

// ---- GETTERS - SETTERS ----