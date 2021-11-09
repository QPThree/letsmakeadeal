package com.display.swing;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private JTextArea textArea;
    public TextField userNameTextField = new TextField(20);
    public JButton dealButton,noDealButton,startButton, howButton, aboutButton, exitButton, continueButton;
    private Container con;
    private JPanel titlePanel, startButtonPanel, howButtonPanel, aboutButtonPanel, exitButtonPanel, continueButtonPanel, mainTextPanel;
    private JLabel titleLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN,64);

    private Frame frame;


    TitleScreenHandler titleScreenHandler;

//    private Host host = new Host();




    public MainFrame() {
        super("Let's Make A Deal");


        setLayout(new BorderLayout());

        textArea = new JTextArea();
        dealButton = new JButton("Let's Make the Deal!");
        noDealButton = new JButton("Walk Away");

        add(textArea, BorderLayout.LINE_END);
        add(dealButton,BorderLayout.SOUTH);



        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.yellow);
        setLayout(null);
        setVisible(true);
        con = getContentPane();


        titlePanel = new JPanel();
        titlePanel.setBounds(150,100,600,150);
        titlePanel.setBackground(Color.yellow);


        titleLabel = new JLabel();
//        titleLabel.setForeground(Color.white);
//        titleLabel.setFont(titleFont);
        titlePanel.add(titleLabel);
        ImageIcon labelIcon=new ImageIcon("resources/LetsMakeDeal.png");
        titleLabel.setIcon(labelIcon);



        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(350,450,200,50);
        startButtonPanel.setBackground(Color.BLACK);
        startButton = new JButton("Start Game");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);

        howButtonPanel = new JPanel();
        howButtonPanel.setBounds(350,500,200,50);
        howButtonPanel.setBackground(Color.red);
        howButton = new JButton("How To Play");
        howButton.setBackground(Color.RED);
        howButton.setForeground(Color.white);

        aboutButtonPanel = new JPanel();
        aboutButtonPanel.setBounds(350,600,200,50);
        aboutButtonPanel.setBackground(Color.GREEN);
        aboutButton = new JButton("About");
        aboutButton.setBackground(Color.white);
        aboutButton.setForeground(Color.red);

        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(350,550,200,50);
        exitButtonPanel.setBackground(Color.yellow);
        exitButton = new JButton("Exit");
        exitButton.setBackground(Color.ORANGE);
        exitButton.setForeground(Color.white);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(75, 600, 400, 75);
        mainTextPanel.setVisible(false);

        continueButtonPanel = new JPanel();
        continueButtonPanel.setBounds(350,550,200,75);
        continueButton = new JButton("Continue");
        continueButton.setBackground(Color.green);
        continueButtonPanel.setVisible(false);





        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);
        howButtonPanel.add(howButton);
        con.add(howButtonPanel);
        aboutButtonPanel.add(aboutButton);
        con.add(aboutButtonPanel);
        exitButtonPanel.add(exitButton);
        con.add(exitButtonPanel);
        mainTextPanel.add(textArea);
        mainTextPanel.add(userNameTextField);
        con.add(mainTextPanel);
        continueButtonPanel.add(continueButton);
        con.add(continueButtonPanel);

        con.add(titlePanel);

    }

    public void createGameScreen(){
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        aboutButtonPanel.setVisible(false);
        howButtonPanel.setVisible(false);
        exitButton.setVisible(false);
//        infoTextPanel.setVisible(false);
        mainTextPanel.setVisible(true);
        continueButtonPanel.setVisible(true);
//        infoTextPanel = new JPanel();
//        infoTextPanel.setBounds(100,100,600,250);
//        infoTextPanel.setBackground(Color.blue);
//        con.add(infoTextPanel);
    }

    public void writeToTextArea(String string){
        textArea.setText(string);
    }

    public void clearTextArea(){
        textArea.setText("");
    }

    public class TitleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }
}
