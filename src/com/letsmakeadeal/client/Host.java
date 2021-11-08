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
    private boolean isPlaying = true;
    private Prompter prompter= new Prompter(new Scanner(System.in));

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
        System.out.println("The reward you chose is:");
        System.out.println(reward.getName() + "!");
    }

    private void endGame() {

        prompter.prompt(user.getName() + "'s final Rewards:");
        user.getRewards();

       readFileFromResources("thanks");

    }

    public void makeOffer() {
        boolean validInput = false;
        while (!validInput) {
            String choice = prompter.prompt("Would you like to risk your current winnings and choose another prize?","[ynYN]"," Please Select [Y]es [N]o");
            if (choice.equalsIgnoreCase("Y")) {
                Reward reward = display.getRandomReward();
                user.addReward(reward);
                showResults(reward);
                if (reward.isZonk()) {
                    this.isPlaying = false;
                    break;
                }
                validInput = true;
            } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("Thanks for playing!");
                this.isPlaying = false;
                validInput = true;
            }
        }
    }

    private void startGame() {
        Reward reward = Reward.CASH_ONE_PRIZES;
        String name = prompter.prompt("Enter your name: ");
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
            selection = prompter.prompt("Ready to Make a Deal? \n [y] Start \n [h] How-To \n [n] Quit", "[ynYNhH]", " Y for yes, N for N, H for How To Play");
            switch (selection.toUpperCase()) {
                case "H":
                    readFileFromResources("how-to");
                    break;
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

    public void readFileFromResources(String fileName){
        Path path=Path.of("resources", fileName+".txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line-> System.out.println(line));
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.getLocalizedMessage();
        }
    }

}
