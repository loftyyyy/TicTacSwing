package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicTacToeAI {
    private JButton[][] board = new JButton[3][3];
    private boolean playerMove = true;
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

            button.setFocusPainted(false);
            button.setFont(new Font("Lato", Font.PLAIN, 120));
            button.setBackground(Color.decode("#F5E7B2"));
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.addActionListener(new BtnActionListener());
            buttonPanel.add(button);
            board[i / 3][i % 3] = button;

        }
        JButton clearBTN = new JButton("Clear");
        controlPanel.add(clearBTN);
        window.getContentPane().add(BorderLayout.CENTER, buttonPanel);

        window.getContentPane().add(BorderLayout.SOUTH, controlPanel);

        window.setSize(500,700);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);


    }
    public void AIMove(JButton[][] board, int depth){
        Minimax minimax = new Minimax();
        float bestEval = Float.NEGATIVE_INFINITY;

        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].getText().isEmpty()){
                    board[i][j].setText("O");
                    float eval = minimax.evaluate(board, depth, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, false);
                    System.out.println(eval);

                }
            }
        }
    }
    class BtnActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedBtn = (JButton) e.getSource();
            if(playerMove){
                clickedBtn.setText("X");
                playerMove = false;
            }else{
//                AIMove(board, 8);

                playerMove = true;
            }

            clickedBtn.setEnabled(false);
        }
    }


}
