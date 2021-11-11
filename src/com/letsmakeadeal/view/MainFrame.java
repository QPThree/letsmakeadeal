package com.letsmakeadeal.view;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    public TextField userNameTextField = new TextField("Enter Name", 20);
    private JTextArea textArea = new JTextArea(20, 20);
    private JTextArea userRewardsText = new JTextArea();
    public JTextArea textField = new JTextArea();
    public JButton dealButton, noDealButton, startButton, howButton, aboutButton,
            exitButton, continueButton, mainButton, backButton;
    private Container con;
    public JPanel titlePanel, menuPanel, subPanel, mainTextPanel, displayPanel,
            userRewardsPanel, backButtonSubPanel, aboutTextPanel, howTextPanel;
    public JLabel titleLabel, chestClosedLabel, chestOpenedLabel, curtainLabel, aboutLabel, howLabel;


    public MainFrame() {
        super("Let's Make A Deal");
        setUpMainMenu();
    }

    public void setUpMainMenu() {
        setFrameConfigs();
        con = getContentPane();

        setAllButtons();
        setAllPanels();
        // ---- LABELS ADDED TO PANELS ----
        titleLabel = new JLabel();
        aboutLabel = new JLabel();
        howLabel = new JLabel();
        titlePanel.add(titleLabel);
        ImageIcon labelIcon = new ImageIcon("resources/LetsMakeDeal.png");
        titleLabel.setIcon(labelIcon);

        userNameTextField.setFont(new Font("Arial", Font.BOLD, 15));
        userNameTextField.setForeground(Color.red);
        userNameTextField.setBackground(Color.white);

        textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        userRewardsText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));


        mainButton.addActionListener(e -> showMainMenu());
        backButton.addActionListener(e -> showMainMenu());

        titlePanel.add(titleLabel);
        menuPanel.add(startButton);
        menuPanel.add(howButton);
        menuPanel.add(aboutButton);
        menuPanel.add(exitButton);
        subPanel.add(dealButton);
        subPanel.add(continueButton);
        subPanel.add(noDealButton);
        subPanel.add(mainButton);
        backButtonSubPanel.add(backButton);
        mainTextPanel.add(textArea);
        displayPanel.add(userNameTextField);
        userRewardsPanel.add(userRewardsText);
        aboutTextPanel.add(aboutLabel);
        howTextPanel.add(howLabel);

        con.add(howTextPanel);
        con.add(aboutTextPanel);
        con.add(subPanel);
        con.add(backButtonSubPanel);
        con.add(menuPanel);
        con.add(displayPanel);
        con.add(mainTextPanel);
        con.add(titlePanel);
        con.add(userRewardsPanel);
        setVisible(true);
    }

    private void setFrameConfigs() {
        setSize(900, 700);
        setResizable(false);        // enable the resize of the frame
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.yellow);
        setLayout(null);
        setVisible(true);
    }

    private void setAllPanels() {
        titlePanel = createJPanel(200, 50, 500, 150, Color.yellow, true);
        menuPanel = createJPanel(350, 300, 175, 225, Color.yellow, true);
        mainTextPanel = createJPanel(250, 450, 400, 75, Color.yellow, false);
        subPanel = createJPanel(150, 550, 600, 75, Color.yellow, false);
        displayPanel = createJPanel(150, 200, 600, 150, Color.yellow, false);
        userRewardsPanel = createJPanel(150, 625, 600, 25, Color.yellow, false);
        backButtonSubPanel = createJPanel(150, 550, 600, 75, Color.yellow, false);
        aboutTextPanel = createJPanel(250, 450, 400, 75, Color.YELLOW, false);
        howTextPanel = createJPanel(250, 450, 400, 75, Color.YELLOW, false);
    }

    private void setAllButtons() {
        startButton = createJButton("Start Game", 150, 50, false, Color.WHITE, Color.GREEN);
        dealButton = createJButton("Let's Make the Deal !", 200, 20, false, Color.yellow, Color.black);
        howButton = createJButton("How To Play", 150, 50, false, Color.WHITE, Color.BLUE);
        aboutButton = createJButton("About", 150, 50, false, Color.WHITE, Color.BLACK);
        exitButton = createJButton("Exit", 150, 50, false, Color.WHITE, Color.RED);
        continueButton = createJButton("Continue", 150, 20, false, Color.white, Color.green);
        noDealButton = createJButton("Walk Away", 200, 20, false, Color.white, Color.red);
        mainButton = createJButton("Main Menu", 200, 20, false, Color.white, Color.blue);
        backButton = createJButton("Back", 200, 20, false, Color.white, Color.blue);
    }


    public void showMainMenu() {
        menuPanel.setVisible(true);
        mainTextPanel.setVisible(false);
        subPanel.setVisible(false);
        displayPanel.setVisible(false);
        userRewardsPanel.setVisible(false);
        aboutTextPanel.setVisible(false);
        howTextPanel.setVisible(false);
        backButtonSubPanel.setVisible(false);
    }

    public void createGameScreen() {
        mainTextPanel.updateUI();
        titlePanel.setVisible(true);
        menuPanel.setVisible(false);
        mainTextPanel.setVisible(true);
        subPanel.setVisible(true);
        displayPanel.setVisible(true);
        userRewardsPanel.setVisible(true);
        writeToUserRewardsPanel("");
        backButtonSubPanel.setVisible(false);
        aboutTextPanel.setVisible(false);
        howTextPanel.setVisible(false);
    }

    public void gameAboutScreen() {

        aboutTextPanel.setBounds(250, 200, 700, 300);
        aboutTextPanel.add(textField);
        aboutTextPanel.setVisible(true);
        titlePanel.setVisible(true);
        menuPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        subPanel.setVisible(false);
        backButtonSubPanel.setVisible(true);
        aboutLabel.setVisible(true);
    }

    public void gameHowScreen() {

        howTextPanel.setBounds(100, 200, 700, 300);
        howTextPanel.add(textField);
        howTextPanel.setVisible(true);
        titlePanel.setVisible(true);
        menuPanel.setVisible(false);
        mainTextPanel.setVisible(false);
        subPanel.setVisible(false);
        backButtonSubPanel.setVisible(true);
        aboutLabel.setVisible(true);
    }

    public void writeToUserRewardsPanel(String string) {
        userRewardsText.setText("Winnings: ");
        userRewardsText.append(string);
        userRewardsText.setFont(new Font("Arial", Font.BOLD, 15));
        userRewardsText.setForeground(Color.RED);
        userRewardsText.setBackground(Color.yellow);
    }


    public void writeToTextArea(String string) {
        textArea.setFont(new Font("Arial", Font.BOLD, 15));
        textArea.setPreferredSize(new Dimension(400, 75));
        textArea.setBackground(Color.yellow);
        textArea.setText(string);
    }

    public void writeToTextField(String string) {
        textField.setFont(new Font("Arial", Font.BOLD, 15));
        textField.setPreferredSize(new Dimension(700, 300));
        textField.setBackground(Color.yellow);
        textField.setText(string);
    }

    public void clearDisplayPanel() {
        displayPanel.removeAll();
    }

    public void displayCurtain() {
        curtainLabel = new JLabel();
        displayPanel.add(curtainLabel);
        ImageIcon curtainIcon = new ImageIcon("resources/curtain1.png");
        displayPanel.add(curtainLabel);
        curtainLabel.setIcon(curtainIcon);
    }

    public void displayOpenedChest() {
        chestOpenedLabel = new JLabel();
        displayPanel.add(chestOpenedLabel);
        ImageIcon chestOpened = new ImageIcon("resources/openedchest.png");
        displayPanel.add(chestOpenedLabel);
        chestOpenedLabel.setIcon(chestOpened);
    }

    public void displayClosedChest() {
        chestClosedLabel = new JLabel();
        displayPanel.remove(curtainLabel);
        displayPanel.add(chestClosedLabel);
        displayPanel.updateUI(); //gets the curtain to be removed
        ImageIcon chestClosed = new ImageIcon("resources/closedchest.png");
        displayPanel.add(chestClosedLabel);
        chestClosedLabel.setIcon(chestClosed);
    }

    private JButton createJButton(String title, int width, int height, boolean focusable, Color foreground, Color background) {
        JButton product = new JButton(title);
        product.setPreferredSize(new Dimension(width, height));
        product.setFocusable(focusable);
        product.setForeground(foreground);
        product.setBackground(background);
        return product;
    }

    private JPanel createJPanel(int x, int y, int width, int height, Color background, boolean visible) {
        JPanel product = new JPanel();
        product.setBounds(x, y, width, height);
        product.setBackground(background);
        product.setVisible(visible);
        return product;
    }


}
