package com.letsmakeadeal.client;


import com.apps.util.Prompter;
import com.letsmakeadeal.view.MainFrame;
import com.letsmakeadeal.Display;
import com.letsmakeadeal.Reward;
import com.letsmakeadeal.User;
import com.letsmakeadeal.UserFactory;

import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Host {

    // ---- FIELDS ----
    private Display display = new Display();//host has-a display
    private User user; //host has-a user
    private boolean isPlaying;
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private MainFrame mainFrame = new MainFrame();


    // ---- CONSTRUCTORS ----

    public Host() {
        this.display = new Display();
        mainFrame.aboutButton.addActionListener(e -> displayAboutUs());
        mainFrame.startButton.addActionListener(e -> execute());
        mainFrame.exitButton.addActionListener(e -> System.exit(0));
        mainFrame.continueButton.addActionListener(e -> startGame());
        mainFrame.dealButton.addActionListener(e -> giveUserAnotherPrize());
        mainFrame.noDealButton.addActionListener(e -> endGame());
    }

    // ---- BUSINESS METHODS ----

    public void execute() {
        mainFrame.createGameScreen();
        greetUser();
//        displayMenu();
    }

    // ---- START GAME FLOW ----
    private void greetUser() {
        mainFrame.writeToTextArea("Welcome user! \n Please enter your name followed by [continue]");
    }

    private void startGame() {
        isPlaying = true;
        Reward reward = Reward.CASH_ONE_PRIZES;
        user = UserFactory.createUser(mainFrame.userNameTextField.getText(), reward);
        mainFrame.userNameTextField.setVisible(false);
        mainFrame.writeToTextArea(user.getName() + ", your initial winning: " + reward.getName() + "\n\n [continue]");

        for (ActionListener al : mainFrame.continueButton.getActionListeners()) {
            mainFrame.continueButton.removeActionListener(al);
        }
        mainFrame.continueButton.addActionListener(e -> makeOffer());
    }

    public void makeOffer() {
        mainFrame.clearDisplayPanel();
        mainFrame.displayCurtain();
        mainFrame.writeToTextArea("Would you like to risk your current winnings\n and choose another prize? \n\n Yes: [Let's Make a Deal]  No: [Walk Away]");

    }

    public void giveUserAnotherPrize() {
        mainFrame.writeToTextArea("Behind this curtain we find a treasure chest!\n[continue] to open");
        mainFrame.clearDisplayPanel();
        mainFrame.displayClosedChest();
        for (ActionListener al : mainFrame.continueButton.getActionListeners()) {
            mainFrame.continueButton.removeActionListener(al);
        }

        Reward reward = display.getRandomReward();
        user.addReward(reward);
        mainFrame.continueButton.addActionListener(e -> showResults(reward));
    }

    private void showResults(Reward reward) {
        mainFrame.writeToTextArea("Inside the chest we find(!) :" + reward.getName() + "!\n\n[continue]");
        mainFrame.writeToUserRewardsPanel(user.getName() + user.getRewards());
        if (reward.isZonk()) {
            this.isPlaying = false;
            displayZonkMessage();
        } else {
            for (ActionListener al : mainFrame.continueButton.getActionListeners()) {
                mainFrame.continueButton.removeActionListener(al);
            }
            mainFrame.clearDisplayPanel();
            mainFrame.displayOpenedChest();
            mainFrame.continueButton.addActionListener(e -> makeOffer());
        }
    }

    private void displayZonkMessage() {
        mainFrame.writeToTextArea("Oh no! You received a " + user.getRewards() + " which is a ZONK! \n\n [continue]");
        for (ActionListener al : mainFrame.continueButton.getActionListeners()) {
            mainFrame.continueButton.removeActionListener(al);
        }
        mainFrame.continueButton.addActionListener(e -> endGame());

    }

    private void endGame() {
        this.isPlaying = false;
        mainFrame.writeToTextArea("Thanks for Playing\n" + user.toString() + "\n\n [main menu] to return home");
    }

    // ---- END GAME FLOW ----

    private void displayAboutUs() {
        mainFrame.gameInfoScreen();
        mainFrame.writeToTextField(readFileFromResources("aboutus"));
    }

    //might use in about us and how-to pages
    public String readFileFromResources(String fileName) {
        String aboutUs = null;
        try {
            aboutUs = Files.readString(Path.of("resources", fileName + ".txt"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return aboutUs;
    }


}
