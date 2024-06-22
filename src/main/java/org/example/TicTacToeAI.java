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
        clearBTN.addActionListener(e -> clearBoard());
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
        int bestEval = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestColumn = -1;

        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].getText().isEmpty()){
                    board[i][j].setText("O");
                    int eval = minimax.evaluate(board, depth, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, false);
                    board[i][j].setText("");
                    if(eval > bestEval){
                        bestEval = eval;
                        bestRow = i;
                        bestColumn = j;
                    }



                }
            }
        }
        if(bestRow != -1 && bestColumn != -1){
            board[bestRow][bestColumn].setText("O");
            board[bestRow][bestColumn].setEnabled(false);
            playerMove = true;
        }
    }
    class BtnActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedBtn = (JButton) e.getSource();
            if(playerMove){
                clickedBtn.setText("X");
                playerMove = false;
                if(checkWin(board) == 0){
                    AIMove(board, 0);
                }
            }

            clickedBtn.setEnabled(false);
        }
    }

    public int checkWin(JButton[][] board){

        // Vertical
        for(int i = 0; i < 3; i++){
            if(board[0][i].getText().equals(board[1][i].getText()) && board[1][i].getText().equals(board[2][i].getText()) && board[2][i].getText().equals(board[0][i].getText()) && !board[0][i].getText().isEmpty() ){
//                board[0][i].setEnabled(true);
//                board[1][i].setEnabled(true);
//                board[2][i].setEnabled(true);

                if(board[0][i].getText().equals("X")){
                    return -1;
                }else if(board[0][i].getText().equals("O")){
                    return 1;
                }

            }
        }
        //Horizontal
        for(int i = 0; i < 3; i++){
            if(board[i][0].getText().equals(board[i][1].getText()) && board[i][1].getText().equals(board[i][2].getText()) && board[i][2].getText().equals(board[i][0].getText()) && !board[i][0].getText().isEmpty() ){
//                board[i][0].setEnabled(true);
//                board[i][1].setEnabled(true);
//                board[i][2].setEnabled(true);

                if(board[i][0].getText().equals("X")){
                    return -1;
                }else if(board[i][0].getText().equals("O")){
                    return 1;
                }
            }
        }
        //Diagonals

        if(board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && board[2][2].getText().equals(board[0][0].getText()) && !board[0][0].getText().isEmpty() ){
//            board[0][0].setEnabled(true);
//            board[1][1].setEnabled(true);
//            board[2][2].setEnabled(true);

            if(board[0][0].getText().equals("X")){
                return -1;
            }else if(board[0][0].getText().equals("O")){
                return 1;
            }
        }

        if(board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) && board[2][0].getText().equals(board[0][2].getText()) && !board[0][2].getText().isEmpty() ){
//            board[0][2].setEnabled(true);
//            board[1][1].setEnabled(true);
//            board[2][0].setEnabled(true);

            if(board[0][2].getText().equals("X")){
                return -1;
            }else if(board[0][2].getText().equals("O")){
                return 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().isEmpty()) {
                    return 0;
                }
            }
        }

        return 2;

    }
    public void showResult(int result) {
        if (result == 1) {
            JOptionPane.showMessageDialog(null, "AI Wins!");
        } else if (result == -1) {
            JOptionPane.showMessageDialog(null, "Player Wins!");
        } else {
            JOptionPane.showMessageDialog(null, "Draw!");
        }

    }
    public void clearBoard(){

                for(int i = 0; i < board.length; i++){
                    for(int j = 0; j < board[i].length; j++){
                        board[i][j].setText("");
                    board[i][j].setEnabled(true);
                    }
                }
                playerMove = true;
            }



}
