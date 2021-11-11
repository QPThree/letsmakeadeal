package com.letsmakeadeal.client;


import com.apps.util.Prompter;
import com.letsmakeadeal.view.MainFrame;
import com.letsmakeadeal.Display;
import com.letsmakeadeal.Reward;
import com.letsmakeadeal.User;
import com.letsmakeadeal.UserFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

class Host {

    // ---- FIELDS ----
    private Display display = new Display();
    private User user; //host has-a user
    private boolean isPlaying;
    private Prompter prompter = new Prompter(new Scanner(System.in));
    private MainFrame mainFrame = new MainFrame();



    // ---- CONSTRUCTORS ----

    Host() {
        this.display = new Display()


        setAllActionListeners();

    }

    // ---- BUSINESS METHODS ---

    public void execute() {
        mainFrame.createGameScreen();
        greetUser();
//        displayMenu();
    }
    public void processExitButton() {

        //System.out.println( "Exit button clicked..." );
        //CreditScreen cs = new CreditScreen();

        //System.exit( 0 );
    }

    // ---- START GAME FLOW ----
    private void greetUser() {
        mainFrame.writeToTextArea("Welcome! \n Please enter your name above, \nfollowed by [continue]");
    }

    private void startGame() {
        isPlaying = true;
        Reward reward = Reward.CASH_ONE_PRIZES;
        user = UserFactory.createUser(mainFrame.userNameTextField.getText(), reward);
        mainFrame.userNameTextField.setVisible(false);
        mainFrame.writeToUserRewardsPanel(user.getName() + user.getRewards());
        mainFrame.writeToTextArea(user.getName() + ", your initial winning: " + reward.getName() + "\n\n [continue]");
        removeActionListener(mainFrame.continueButton);
        mainFrame.continueButton.addActionListener(e -> makeOffer());
    }

    private void makeOffer() {
        mainFrame.clearDisplayPanel();
        mainFrame.displayCurtain();
        mainFrame.writeToTextArea("Would you like to risk your current winnings\n and choose another prize? \n\n Yes: [Let's Make a Deal]  No: [Walk Away]");

    }

    private void giveUserAnotherPrize() {
        mainFrame.writeToTextArea("Behind this curtain we find a treasure chest!\n[continue] to open");
        mainFrame.clearDisplayPanel();
        mainFrame.displayClosedChest();
        removeActionListener(mainFrame.continueButton);
        Reward reward = display.getRandomReward();
        user.addReward(reward);
        mainFrame.continueButton.addActionListener(e -> showResults(reward));
    }

    private void showResults(Reward reward) {
        mainFrame.writeToTextArea("Inside the chest we find(!) :" + reward.getName() + "!\n\n[continue]");
        mainFrame.writeToUserRewardsPanel(user.getName() + user.getRewards());
        mainFrame.clearDisplayPanel();
        mainFrame.displayOpenedChest();
        if (reward.isZonk()) {
            this.isPlaying = false;
            displayZonkMessage();
        } else {
            removeActionListener(mainFrame.continueButton);
            mainFrame.continueButton.addActionListener(e -> makeOffer());
        }
    }

    private void displayZonkMessage() {
        mainFrame.writeToTextArea("Oh no! You received a " + user.getRewards() + " which is a ZONK! \n\n [continue]");
        removeActionListener(mainFrame.continueButton);
        removeActionListener(mainFrame.dealButton);
        mainFrame.continueButton.addActionListener(e -> endGame());

    }

    private void endGame() {
        this.isPlaying = false;
        removeActionListener(mainFrame.dealButton);

        mainFrame.writeToTextArea("Thanks for Playing\n" + user.toString() + "\n\n [main menu] to return home");
    }

    // ---- END GAME FLOW ----

    private void setAllActionListeners() {
        mainFrame.aboutButton.addActionListener(e -> displayAboutUs());
        mainFrame.startButton.addActionListener(e -> execute());
        mainFrame.exitButton.addActionListener(e -> System.exit(0));
        mainFrame.continueButton.addActionListener(e -> startGame());
        mainFrame.dealButton.addActionListener(e -> giveUserAnotherPrize());
        mainFrame.noDealButton.addActionListener(e -> endGame());

    }

    private void removeActionListener(JButton button) {
        for (ActionListener al : button.getActionListeners()) {
            button.removeActionListener(al);
        }
    }

    private void displayAboutUs() {
        mainFrame.gameInfoScreen();
        mainFrame.writeToTextField(readFileFromResources("aboutus"));
    }

    //might use in about us and how-to pages
    private String readFileFromResources(String fileName) {
        String aboutUs = null;
        try {
            aboutUs = Files.readString(Path.of("resources", fileName + ".txt"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return aboutUs;
    }



}
