package com.letsmakeadeal.client;

import com.apps.util.SplashApp;
import com.display.swing.MainFrame;

import javax.swing.*;


public class Main {

//    @Override
//    public void start(){
//        Host host = new Host();
//        host.execute();
//    }
    public static void main(String[] args) {
        //starting point here

//        Host host = new Host();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Host() ;}
        });

//        Main main = new Main();
//
//            main.welcome("/images/lmad.jpeg");
//
//
//        main.start();
    }

}
