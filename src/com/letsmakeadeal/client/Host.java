package com.letsmakeadeal.client;


import com.apps.util.Prompter;
import com.letsmakeadeal.Display;
import com.letsmakeadeal.Reward;
import com.letsmakeadeal.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class Host {

    // ---- FIELDS ----
    private Display display = new Display();//host has-a display
//    ArrayList<Reward> rewardsArray = new ArrayList<Reward>(List.of(Reward.values())); //refactor this to be coming from display class
    private User user; //host has-a user
    private boolean isPlaying = true;
    Scanner scanner = new Scanner(System.in);
    private Prompter prompter= new Prompter(scanner);

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

        prompter.prompt("Your final Rewards:");
        user.getRewards();

        Path path=Path.of("resources", "thanks.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line-> System.out.println(line));
        } catch (IOException e) {
            // do something or re-throw...
        }

    }

    public void makeOffer() {
        boolean validInput = false;
        while (!validInput) {
            String choice = prompter.prompt("Would you like to choose another prize?","[ynYN]"," [Y]es [N]o");


            if (choice.toUpperCase().equals("Y")) {
                Reward reward = display.getRandomReward();
                user.addReward(reward);
                showResults(reward);
                if (reward.isZonk()) {
                    this.isPlaying = false;
                    break;
                }
                System.out.println("Would you like to make another deal?!");
                validInput = true;
            } else if (choice.toUpperCase().equals("N")) {
                System.out.println("Thanks for playing!");
                this.isPlaying = false;
                validInput = true;
            }
        }
    }


    private void startGame() {
        Reward reward = display.getRandomReward(); // This  is randomized
        user.addReward(reward);                 //sets initial reward for the user

    }

    private void greetUser() {

        Path path=Path.of("resources", "banner.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line-> System.out.println(line));
        } catch (IOException e) {
            // do something or re-throw...
        }


    }

    //---- from jasmine ----
    public void displayMenu() {
        boolean quit = false;
        String selection;
        while (!quit) {
            selection =prompter.prompt("\"Are you ready to make a deal?\"", "[ynYN]", " Y for yes, N for N");

            switch (selection.toUpperCase()) {
                case "Y":
                    startGame(); //initialize user with default reward (user.setReward)
                    while (isPlaying) {
                        makeOffer();
                    }
                    endGame();
                    break;
                case "N":
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