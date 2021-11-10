package com.display.swing;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JTextArea textArea;
    public TextField userNameTextField = new TextField(20);
    public JTextField textField;
    public JButton dealButton, noDealButton, startButton, howButton, aboutButton, exitButton, continueButton;
    private Container con;
    private JPanel titlePanel, menuPanel, subPanel, mainTextPanel,displayPanel, continueButtonPanel, startButtonPanel, howButtonPanel, aboutButtonPanel, exitButtonPanel;
    private JLabel titleLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 64);

    TitleScreenHandler titleScreenHandler;

//    private Host host = new Host();


    public MainFrame() {
        super("Let's Make A Deal");

        setLayout(new BorderLayout());
        setSize(900, 700);
        setResizable(false);        // enable the resize of the frame
//        setFocusable(true);
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

//        startButtonPanel = new JPanel();
//        startButtonPanel.setBounds(350,450,200,50);
//        startButtonPanel.setBackground(Color.BLACK);
        startButton = new JButton("Start Game");
        startButton.setFocusable(false);
        startButton.setPreferredSize(new Dimension(150, 50));
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);

//        howButtonPanel = new JPanel();
//        howButtonPanel.setBounds(350,500,200,50);
//        howButtonPanel.setBackground(Color.red);
        howButton = new JButton("How To Play");
        howButton.setFocusable(false);
        howButton.setPreferredSize(new Dimension(150, 50));
        howButton.setBackground(Color.RED);
        howButton.setForeground(Color.white);

//        aboutButtonPanel = new JPanel();
//        aboutButtonPanel.setBounds(350,600,200,50);
//        aboutButtonPanel.setBackground(Color.GREEN);
        aboutButton = new JButton("About");
        aboutButton.setFocusable(false);
//        aboutButton.setBounds(350,550,200,50);
        aboutButton.setPreferredSize(new Dimension(150, 50));
        aboutButton.setBackground(Color.white);
        aboutButton.setForeground(Color.red);

//        exitButtonPanel = new JPanel();
//        exitButtonPanel.setBounds(350,550,200,50);
//        exitButtonPanel.setBackground(Color.yellow);
        exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
        exitButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setBackground(Color.ORANGE);
        exitButton.setForeground(Color.white);
        exitButton.addActionListener(e -> System.exit(0));


//        continueButtonPanel = new JPanel();
//        continueButtonPanel.setBounds(350,550,200,75);
//        continueButtonPanel.setBackground(Color.yellow);
        continueButton = new JButton("Continue");
        continueButton.setFocusable(false);
        continueButton.setPreferredSize(new Dimension(150, 20));
        continueButton.setBackground(Color.green);
//        continueButtonPanel.setVisible(false);


        textArea = new JTextArea();
        textField=new JTextField();
//        add(textArea, BorderLayout.LINE_END);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(250, 450, 400, 75);
        mainTextPanel.setBackground(Color.green);
        mainTextPanel.setVisible(false);
        userNameTextField.setFont(new Font("Arial",Font.BOLD,15));
        userNameTextField.setForeground(Color.blue);
        userNameTextField.setBackground(Color.yellow);


        subPanel = new JPanel();
        subPanel.setBounds(150, 550, 600, 50);
        subPanel.setBackground(Color.yellow);
        subPanel.setVisible(false);

        displayPanel=new JPanel();
        displayPanel.setBounds(150, 300, 600, 50);
        displayPanel.setBackground(Color.white);
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


        titlePanel.add(titleLabel);
        menuPanel.add(startButton);
        menuPanel.add(howButton);
        menuPanel.add(aboutButton);
        menuPanel.add(exitButton);
        subPanel.add(dealButton);
        subPanel.add(continueButton);
        subPanel.add(noDealButton);
        con.add(subPanel);
        con.add(menuPanel);
        con.add(displayPanel);
//        startButtonPanel.add(startButton);
//        con.add(startButtonPanel);
//        howButtonPanel.add(howButton);
//        con.add(howButtonPanel);
//        aboutButtonPanel.add(aboutButton);
//        con.add(aboutButtonPanel);
//        exitButtonPanel.add(exitButton);
//        con.add(exitButtonPanel);
        mainTextPanel.add(textArea);
        mainTextPanel.add(userNameTextField);
        con.add(mainTextPanel);
//        continueButtonPanel.add(continueButton);
//        con.add(continueButtonPanel);
        con.add(titlePanel);


    }

    public void createGameScreen() {
        titlePanel.setVisible(true);
//        startButtonPanel.setVisible(false);
//        howButtonPanel.setVisible(false);
//        aboutButtonPanel.setVisible(false);
//        exitButtonPanel.setVisible(false);
        menuPanel.setVisible(false);

//        infoTextPanel.setVisible(false);
        mainTextPanel.setVisible(true);
//        continueButtonPanel.setVisible(true);
        subPanel.setVisible(true);
        displayPanel.setVisible(true);
//        infoTextPanel = new JPanel();
//        infoTextPanel.setBounds(100,100,600,250);
//        infoTextPanel.setBackground(Color.blue);
//        con.add(infoTextPanel);

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
        textArea.setText(string);
    }

    public void clearTextArea() {
        textArea.setText("");
    }

    public void writeToTextField(String string){
        textField.setFont(new Font("Arial",Font.BOLD,15));
        textField.setPreferredSize(new Dimension(400,100));
        textField.setBackground(Color.green);
        textField.setText(string);
    }

    public class TitleScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }
}
