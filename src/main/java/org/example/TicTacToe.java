package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TicTacToe {
    private ArrayList<JButton> buttons = new ArrayList<>();
    public static void main(String[] args) {
        new TicTacToe().startGUI();

    }
    public void startGUI(){
        JFrame window = new JFrame();
        JPanel buttonPanel = new JPanel();

        for(int i = 0; i < 9;i++){
            JButton button = new JButton();
            buttons.add(button);
            buttonPanel.add(button);
        }

        window.getContentPane().add(BorderLayout.CENTER, buttonPanel);

        window.setSize(500,700);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);



    }
}