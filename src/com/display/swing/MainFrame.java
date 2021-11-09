package com.display.swing;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainFrame extends JFrame{

    private JTextArea textArea;
    private JButton dealButton,noDealButton,startButton, howButton, exitButton ;
    private Container con;
    private JPanel titlePanel, startButtonPanel, howButtonPanel, exitButtonPanel, infoTextPanel;
    private JLabel titleLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN,64);

    private Frame frame;


    TitleScreenHandler titleScreenHandler;




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
        startButton.addActionListener(titleScreenHandler);

        howButtonPanel = new JPanel();
        howButtonPanel.setBounds(350,500,200,50);
        howButtonPanel.setBackground(Color.red);
        howButton = new JButton("How To Play");
        howButton.setBackground(Color.RED);
        howButton.setForeground(Color.white);

        exitButtonPanel = new JPanel();
        exitButtonPanel.setBounds(350,550,200,50);
        exitButtonPanel.setBackground(Color.BLACK);
        exitButton = new JButton("Exit");
        exitButton.setBackground(Color.ORANGE);
        exitButton.setForeground(Color.white);


        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);
        howButtonPanel.add(howButton);
        con.add(howButtonPanel);
        exitButtonPanel.add(exitButton);
        con.add(exitButtonPanel);

        con.add(titlePanel);

    }
    public void createGameScreen(){
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        infoTextPanel = new JPanel();
        infoTextPanel.setBounds(100,100,600,250);
        infoTextPanel.setBackground(Color.blue);
        con.add(infoTextPanel);



    }
    public class TitleScreenHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            createGameScreen();
        }
    }
}
