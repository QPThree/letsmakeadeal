package com.letsmakeadeal.client;


import com.apps.util.Prompter;
import com.letsmakeadeal.Display;
import com.letsmakeadeal.Reward;
import com.letsmakeadeal.User;
import com.letsmakeadeal.UserFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

class Host {

    // ---- FIELDS ----
    private Display display = new Display();//host has-a display
    private User user; //host has-a user
    private boolean isPlaying;
    private Prompter prompter = new Prompter(new Scanner(System.in));

    // ---- CONSTRUCTORS ----

    Host() {
        this.display = new Display();
    }

    // ---- BUSINESS METHODS ----

    public void execute() {
        greetUser();
        displayMenu();
    }

    private void showResults(Reward reward) {
        System.out.println("The reward you chose is:" + reward.getName() + "!");
    }

    private void endGame() {
        this.isPlaying = false;
        prompter.prompt(user.toString());
        readFileFromResources("thanks");
    }

    public void makeOffer() {
        String choice = prompter.prompt("Would you like to risk your current winnings and choose another prize? \n", "[ynYN]", " Please Select [Y]es [N]o");
        if (choice.equalsIgnoreCase("Y")) {
            giveUserAnotherPrize();
        } else if (choice.equalsIgnoreCase("N")) {
            isPlaying = false;
        }
    }

    private void startGame() {
        isPlaying = true;
        Reward reward = Reward.CASH_ONE_PRIZES;
        String name = prompter.prompt("Enter your name: ", "[a-zA-Z]+", "Please enter a valid name");
        user = UserFactory.createUser(name, reward);
        prompter.prompt(user.getName() + ", your initial winning is: " + reward.getName());
    }

    private void greetUser() {
        readFileFromResources("banner");
    }

    public void displayMenu() {
        boolean quit = false;
        String selection;
        while (!quit) {
            selection = prompter.prompt("Ready to Make a Deal? \n [y] Start \n [h] How-To \n [a] About this Project \n [q] Quit \n", "[yqYQhHaA]", " Y for yes, Q for Quit, H for How To Play");
            switch (selection.toUpperCase()) {
                case "Y":
                    startGame(); //initialize user with default reward (user.setReward)
                    while (isPlaying) {
                        makeOffer();
                    }
                    endGame();
                    break;
                case "H":
                    readFileFromResources("how-to");
                    break;
                case "A":
                    displayAboutUs();
                    break;
                case "Q":
                    quit = true;
                    break;
            }
        }
    }

    private void displayAboutUs() {
        readFileFromResources("aboutus");
    }

    public void readFileFromResources(String fileName) {
        Path path = Path.of("resources", fileName + ".txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.getLocalizedMessage();
        }
    }

    public void giveUserAnotherPrize() {
        readFileFromResources("curtain");
        prompter.prompt("Behind this curtain has 5 treasure chest \n");
        readFileFromResources("rewardselection");
        prompter.prompt("Chooses a chest numbered 1-5 \n", "[12345]", "You must choose a number 1 thru 5");
        Reward reward = display.getRandomReward();
        user.addReward(reward);
        showResults(reward);
        if (reward.isZonk()) {
            this.isPlaying = false;
        }
    }

}
