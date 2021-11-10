package com.letsmakeadeal.view;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    public TextField userNameTextField = new TextField(20);
    private JTextArea textArea = new JTextArea(20, 20);
    private JTextArea userRewardsText = new JTextArea();
    public JTextField textField = new JTextField();
    public JButton dealButton, noDealButton, startButton, howButton, aboutButton, exitButton, continueButton, mainButton;
    private Container con;
    public JPanel titlePanel, menuPanel, subPanel, mainTextPanel, displayPanel, userRewardsPanel;
    public JLabel titleLabel, chestClosedLabel, chestOpenedLabel, curtainLabel;

    public MainFrame() {
        super("Let's Make A Deal");
        setUpMainMenu();
    }

    public void setUpMainMenu() {

        setSize(900, 700);
        setResizable(false);        // enable the resize of the frame
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.yellow);
        setLayout(null);
        setVisible(true);
        con = getContentPane();

        // ---- BUTTONS ----
        startButton = createJButton("Start Game", 150, 50, false, Color.black, Color.white);
        dealButton = createJButton("Let's Make the Deal !", 200, 20, false, Color.yellow, Color.black);
        howButton = createJButton("How To Play", 150, 50, false, Color.red, Color.white);
        aboutButton = createJButton("About", 150, 50, false, Color.red, Color.red);
        exitButton = createJButton("Exit", 150, 50, false, Color.ORANGE, Color.ORANGE);
        continueButton = createJButton("Continue", 150, 20, false, Color.white, Color.green);
        noDealButton = createJButton("Walk Away", 200,20, false, Color.white, Color.red);
        mainButton = createJButton("Main Menu", 200, 20, false, Color.white, Color.blue);


        // ---- PANELS ----
        titlePanel = createJPanel(200,50,500,150,Color.yellow, true);
        menuPanel = createJPanel(350, 300, 175, 225, Color.yellow, true);
        mainTextPanel = createJPanel(250, 450, 400, 75, Color.lightGray, false);
        subPanel = createJPanel(150, 550, 600, 75, Color.yellow, false);
        displayPanel = createJPanel(150, 200, 600, 150, Color.yellow, false);
        userRewardsPanel = createJPanel(175, 650, 600, 25, Color.orange, false);

        // ---- LABELS ADDED TO PANELS ----
        titleLabel = new JLabel();
        titlePanel.add(titleLabel);
        ImageIcon labelIcon = new ImageIcon("resources/LetsMakeDeal.png");
        titleLabel.setIcon(labelIcon);

        userNameTextField.setFont(new Font("Arial", Font.BOLD, 15));
        userNameTextField.setForeground(Color.blue);
        userNameTextField.setBackground(Color.black);


        exitButton.addActionListener(e -> System.exit(0));
        mainButton.addActionListener(e -> showMainMenu());


        titlePanel.add(titleLabel);
        menuPanel.add(startButton);
        menuPanel.add(howButton);
        menuPanel.add(aboutButton);
        menuPanel.add(exitButton);
        subPanel.add(dealButton);
        subPanel.add(continueButton);
        subPanel.add(noDealButton);
        subPanel.add(mainButton);
        mainTextPanel.add(textArea);
        mainTextPanel.add(userNameTextField);
        userRewardsPanel.add(userRewardsText);

        con.add(subPanel);
        con.add(menuPanel);
        con.add(displayPanel);
        con.add(mainTextPanel);
        con.add(titlePanel);
        con.add(userRewardsPanel);
    }


    public void showMainMenu() {
        menuPanel.setVisible(true);
        mainTextPanel.setVisible(false);
        subPanel.setVisible(false);
        displayPanel.setVisible(false);

    }

    public void createGameScreen() {
        titlePanel.setVisible(true);
        menuPanel.setVisible(false);
        mainTextPanel.setVisible(true);
        subPanel.setVisible(true);
        displayPanel.setVisible(true);
        userRewardsPanel.setVisible(true);
        writeToUserRewardsPanel("");
    }

    public void gameInfoScreen() {
        mainTextPanel.remove(textArea);
        mainTextPanel.remove(userNameTextField);
        mainTextPanel.setBounds(250, 300, 400, 100);
        mainTextPanel.add(textField);
        titlePanel.setVisible(true);
        menuPanel.setVisible(false);
        mainTextPanel.setVisible(true);
        subPanel.setVisible(true);
    }

    public void writeToUserRewardsPanel(String string){
        userRewardsText.setText("Winnings: ");
        userRewardsText.append(string);
    }


    public void writeToTextArea(String string) {
        textArea.setFont(new Font("Arial", Font.BOLD, 15));
        textArea.setBackground(Color.lightGray);
        textArea.setText(string);
    }

    public void writeToTextField(String string) {
        textField.setFont(new Font("Arial", Font.BOLD, 15));
        textField.setPreferredSize(new Dimension(400, 100));
//        textField.setBackground(Color.lightGray);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
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

    private JPanel createJPanel(int x, int y, int width, int height, Color background, boolean visible ){
        JPanel product = new JPanel();
        product.setBounds(x,y,width,height);
        product.setBackground(background);
        product.setVisible(visible);
        return product;
    }
}
