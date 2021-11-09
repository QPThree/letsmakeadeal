package com.display.swing;

import javax.swing.*;

public class StarterFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();           }
        });

    }
}
