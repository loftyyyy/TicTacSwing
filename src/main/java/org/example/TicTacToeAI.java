package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicTacToeAI {
    private JButton[][] board = new JButton[3][3];
    //TODO: Create a AIMove and PlayerMove methods
    // also create a checkWin that takes a board as the argument.

    public static void main(String[] args){

        new TicTacToeAI().startGUI();
    }
    public void startGUI(){
        JFrame window = new JFrame("TicTacToe AI");
        JPanel buttonPanel = new JPanel(new GridLayout(3,3));
        JPanel controlPanel = new JPanel(new GridLayout(1,3));

        for(int i = 0; i < 9; i++){
            JButton button = new JButton();




        }


    }


}
