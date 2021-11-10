package com.display.swing;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private JTextArea textArea;
    public TextField userNameTextField = new TextField(20);
    public JTextField textField;
    public JButton dealButton, noDealButton, startButton, howButton, aboutButton, exitButton, continueButton,mainButton;
    private Container con;
    public JPanel titlePanel, menuPanel, subPanel, mainTextPanel,displayPanel;
    public JLabel titleLabel,chestClosedLabel,chestOpenedLabel,curtainLabel;

    public MainFrame() {
        super("Let's Make A Deal");
        setUpMainMenu();
    }

    public void setUpMainMenu() {

        setLayout(new BorderLayout());
        setSize(900, 700);
        setResizable(false);        // enable the resize of the frame
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.yellow);
        setLayout(null);
        setVisible(true);
        con = getContentPane();


        titlePanel = new JPanel();

        titlePanel.setBounds(200, 50, 500, 150);
        titlePanel.setBackground(Color.yellow);
        titleLabel = new JLabel();
        titlePanel.add(titleLabel);
        ImageIcon labelIcon = new ImageIcon("resources/LetsMakeDeal.png");
        titleLabel.setIcon(labelIcon);

        menuPanel = new JPanel();
        menuPanel.setBounds(350, 300, 175, 225);
        menuPanel.setBackground(Color.yellow);
        menuPanel.setVisible(true);


        startButton = new JButton("Start Game");
        startButton.setFocusable(false);
        startButton.setPreferredSize(new Dimension(150, 50));
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);


        howButton = new JButton("How To Play");
        howButton.setFocusable(false);
        howButton.setPreferredSize(new Dimension(150, 50));
        howButton.setBackground(Color.RED);
        howButton.setForeground(Color.white);


        aboutButton = new JButton("About");
        aboutButton.setFocusable(false);
        aboutButton.setPreferredSize(new Dimension(150, 50));
        aboutButton.setBackground(Color.white);
        aboutButton.setForeground(Color.red);


        exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
        exitButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setBackground(Color.ORANGE);
        exitButton.setForeground(Color.white);
        exitButton.addActionListener(e -> System.exit(0));



        continueButton = new JButton("Continue");
        continueButton.setFocusable(false);
        continueButton.setPreferredSize(new Dimension(150, 20));
        continueButton.setBackground(Color.green);


        textArea = new JTextArea();
        textField=new JTextField();

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(250, 450, 400, 75);
        mainTextPanel.setBackground(Color.green);
        mainTextPanel.setVisible(false);
        userNameTextField.setFont(new Font("Arial",Font.BOLD,15));
        userNameTextField.setForeground(Color.blue);
        userNameTextField.setBackground(Color.yellow);


        subPanel = new JPanel();
        subPanel.setBounds(150, 550, 600, 75);
        subPanel.setBackground(Color.yellow);
        subPanel.setVisible(false);

        displayPanel=new JPanel();
        displayPanel.setBounds(150, 200, 600, 150);
        displayPanel.setBackground(Color.yellow);
        displayPanel.setVisible(false);


        dealButton = new JButton("Let's Make the Deal !");
        dealButton.setPreferredSize(new Dimension(200, 20));
        dealButton.setFocusable(false);
        dealButton.setForeground(Color.white);
        dealButton.setBackground(Color.black);

        noDealButton = new JButton("Walk Away");
        noDealButton.setFocusable(false);
        noDealButton.setForeground(Color.white);
        noDealButton.setBackground(Color.red);
        noDealButton.setPreferredSize(new Dimension(200, 20));

        mainButton = new JButton("Main Menu");
        mainButton.setFocusable(false);
        mainButton.setForeground(Color.white);
        mainButton.setBackground(Color.BLUE);
        mainButton.setPreferredSize(new Dimension(200, 20));
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
        con.add(subPanel);
        con.add(menuPanel);
        con.add(displayPanel);
        mainTextPanel.add(textArea);
        mainTextPanel.add(userNameTextField);
        con.add(mainTextPanel);
        con.add(titlePanel);
    }


    public void showMainMenu () {
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
    }

    public void gameInfoScreen(){
        mainTextPanel.remove(textArea);
        mainTextPanel.remove(userNameTextField);
        mainTextPanel.setBounds(250, 300, 400, 100);
        mainTextPanel.add(textField);
        titlePanel.setVisible(true);
        menuPanel.setVisible(false);
        mainTextPanel.setVisible(true);
        subPanel.setVisible(true);
    }



    public void writeToTextArea(String string) {
        textArea.setFont(new Font("Arial",Font.BOLD,15));
        textArea.setBackground(Color.green);
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
        textArea.setText(string);
    }

    public void writeToTextField(String string){
        textField.setFont(new Font("Arial",Font.BOLD,15));
        textField.setPreferredSize(new Dimension(400,100));
        textField.setBackground(Color.green);
        textField.setText(string);
    }


    public void clearDisplayPanel(){
        displayPanel.removeAll();
    }

    public void displayCurtain(){
        curtainLabel=new JLabel();
        displayPanel.add(curtainLabel);
        ImageIcon curtainIcon = new ImageIcon("resources/curtain1.png");
        displayPanel.add(curtainLabel);
        curtainLabel.setIcon(curtainIcon);
    }


    public void displayOpenedChest(){
        chestOpenedLabel=new JLabel();
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
}
