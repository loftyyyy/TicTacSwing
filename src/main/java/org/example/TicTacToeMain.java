package org.example;
import javax.swing.*;

public class TicTacToeMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        MainMenuPanel mainMenuPanel = new MainMenuPanel(frame);
        frame.add(mainMenuPanel);

        frame.setVisible(true);
    }
}
