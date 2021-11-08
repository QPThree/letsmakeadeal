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
//        System.out.println("\n" +
//                "  _______ _                 _           __                   _             _             _ \n" +
//                " |__   __| |               | |         / _|                 | |           (_)           | |\n" +
//                "    | |  | |__   __ _ _ __ | | _____  | |_ ___  _ __   _ __ | | __ _ _   _ _ _ __   __ _| |\n" +
//                "    | |  | '_ \\ / _` | '_ \\| |/ / __| |  _/ _ \\| '__| | '_ \\| |/ _` | | | | | '_ \\ / _` | |\n" +
//                "    | |  | | | | (_| | | | |   <\\__ \\ | || (_) | |    | |_) | | (_| | |_| | | | | | (_| |_|\n" +
//                "    |_|  |_| |_|\\__,_|_| |_|_|\\_\\___/ |_| \\___/|_|    | .__/|_|\\__,_|\\__, |_|_| |_|\\__, (_)\n" +
//                "                                                      | |             __/ |         __/ |  \n" +
//                "                                                      |_|            |___/         |___/   \n");
//        System.out.println("You final Rewards:");

        Path path=Path.of("resources", "thanks.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line-> System.out.println(line));
        } catch (IOException e) {
            // do something or re-throw...
        }
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
        System.out.println("user.setReward will be called from within Host.It will pass into it a randomized reward from the display");

        Reward reward = display.getRandomReward(); // This  is randomized
        user.addReward(reward);                 //sets initial reward for the user

    }

    private void greetUser() {
//        System.out.println("\n" +
//                "  _          _         __  __       _                     _____             _ _ \n" +
//                " | |        | |       |  \\/  |     | |            /\\     |  __ \\           | | |\n" +
//                " | |     ___| |_ ___  | \\  / | __ _| | _____     /  \\    | |  | | ___  __ _| | |\n" +
//                " | |    / _ \\ __/ __| | |\\/| |/ _` | |/ / _ \\   / /\\ \\   | |  | |/ _ \\/ _` | | |\n" +
//                " | |___|  __/ |_\\__ \\ | |  | | (_| |   <  __/  / ____ \\  | |__| |  __/ (_| | |_|\n" +
//                " |______\\___|\\__|___/ |_|  |_|\\__,_|_|\\_\\___| /_/    \\_\\ |_____/ \\___|\\__,_|_(_)\n" +
//                "                                                                                \n" +
//                "                                                                                \n");

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