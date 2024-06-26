package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TicTacToeAI {
    // Author @loftyyyy
    // Resources: Sebastian Lague's Algorithms Explained – minimax and alpha-beta pruning [https://www.youtube.com/watch?v=l-hh51ncgDI]

    private JButton[][] board = new JButton[3][3];
    private boolean playerMove = true;
    private JLabel playerLabel;
    private JLabel computerLabel;
    private int playerScore = 0;
    private int computerScore = 0;


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

        playerLabel = new JLabel("X : " + playerScore);
        computerLabel = new JLabel("O : " + computerScore);

        playerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        computerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        playerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        computerLabel.setFont(new Font("Arial", Font.BOLD, 24));

        controlPanel.add(playerLabel);
        controlPanel.add(clearBTN);
        controlPanel.add(computerLabel);

        window.getContentPane().add(BorderLayout.CENTER, buttonPanel);
        window.getContentPane().add(BorderLayout.SOUTH, controlPanel);

        window.setSize(500,700);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
    }

    /**
     *
     * @param board
     * @param depth
     */
    public void AIMove(JButton[][] board, int depth){
        Minimax minimax = new Minimax();
        int bestEval = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestColumn = -1;

        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].getText().isEmpty()){
                    board[i][j].setText("O");
                    int eval = minimax.evaluate(board, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
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

    /**
     *
     * @param board
     * @return
     */
    public int checkWin(JButton[][] board){

        // Vertical and Horizontal
        for(int i = 0; i < 3; i++){
            if(board[0][i].getText().equals(board[1][i].getText()) && board[1][i].getText().equals(board[2][i].getText()) && board[2][i].getText().equals(board[0][i].getText()) && !board[0][i].getText().isEmpty() ){
                board[0][i].setEnabled(true);
                board[1][i].setEnabled(true);
                board[2][i].setEnabled(true);

                return board[0][i].getText().equals("X") ? -1 : 1;


            }
            if(board[i][0].getText().equals(board[i][1].getText()) && board[i][1].getText().equals(board[i][2].getText()) && board[i][2].getText().equals(board[i][0].getText()) && !board[i][0].getText().isEmpty() ){
                board[i][0].setEnabled(true);
                board[i][1].setEnabled(true);
                board[i][2].setEnabled(true);

                return board[i][0].getText().equals("X") ? -1 : 1;
            }
        }
        //Diagonals

        if(board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && board[2][2].getText().equals(board[0][0].getText()) && !board[0][0].getText().isEmpty() ){
            board[0][0].setEnabled(true);
            board[1][1].setEnabled(true);
            board[2][2].setEnabled(true);

            return board[0][0].getText().equals("X") ? -1 : 1;
        }

        if(board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) && board[2][0].getText().equals(board[0][2].getText()) && !board[0][2].getText().isEmpty() ){
            board[0][2].setEnabled(true);
            board[1][1].setEnabled(true);
            board[2][0].setEnabled(true);

            return board[0][2].getText().equals("X") ? -1 : 1;
        }

        //Check draw
        // If returns 0, it means a move can still be made. If 2, that means that there are no moves available and no one won. So it's a draw.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].getText().isEmpty()) {
                    return 0;
                }
            }
        }

        return 2;

    }
    public void updateScore(){
        playerLabel.setText("X : " + playerScore);
        computerLabel.setText("O : " + computerScore);
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
            if(checkWin(board) != 0){
                // Implemented Runnable so that it highlights the winning combination before showing the message dialog
                SwingUtilities.invokeLater(new showMessage(checkWin(board)));
            }

            clickedBtn.setEnabled(false);
        }
    }

    class showMessage implements Runnable{
        int result;
        showMessage(int result){
            this.result = result;

        }
        @Override
        public void run() {

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "AI Wins!");
                computerScore++;
            } else if (result == -1) {
                JOptionPane.showMessageDialog(null, "Player Wins!");
                playerScore++;
            } else {
                JOptionPane.showMessageDialog(null, "Draw!");
            }
            clearBoard();
            updateScore();

        }
    }
}
