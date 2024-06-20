package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TicTacToe {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private char currentChar = 'X';
    private JButton[][] board = new JButton[3][3];
    private JLabel oLabel = new JLabel("O: ");
    private JLabel xLabel = new JLabel("X: ");
    private int moveCount;
    private boolean won = false;
    private int Xscore = 0;
    private int Oscore = 0;

    public static void main(String[] args) {
        new TicTacToe().startGUI();

    }
    public void startGUI(){
        JFrame window = new JFrame("Tic Tac Toe ");
        JPanel buttonPanel = new JPanel(new GridLayout(3,3));
        JPanel controlPanel = new JPanel(new GridLayout(1,3));

        for(int i = 0; i < 9;i++){
            JButton button = new JButton();
//            button.setPreferredSize();
            button.setFocusPainted(false);
            button.setFont(new Font("Lato", Font.PLAIN, 120));
            button.setBackground(Color.decode("#F5E7B2"));
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.addActionListener(new ButtonActionListener());
            board[i / 3][i % 3] = button;
//            System.out.println("[" + i / 3 + "]" + "[" + i % 3 +  "]");
            buttons.add(button);
            buttonPanel.add(button);
        }
        JButton clearButton = new JButton("Clear Table");
        clearButton.addActionListener(e -> buttons.stream().forEach(button -> {button.setText("");button.setEnabled(true); currentChar = 'X'; won = false; moveCount = 0;}));



        controlPanel.add(xLabel);
        controlPanel.add(clearButton);
        controlPanel.add(oLabel);

        window.getContentPane().add(BorderLayout.CENTER, buttonPanel);
        window.getContentPane().add(BorderLayout.SOUTH, controlPanel);

        window.setSize(500,700);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);



    }
    public void getScore(){

    }
    public void checkWin(){
        moveCount++;
        // Vertical
        for(int i = 0; i < 3; i++){
            if(board[0][i].getText().equals(board[1][i].getText()) && board[1][i].getText().equals(board[2][i].getText()) && board[2][i].getText().equals(board[0][i].getText()) && !board[0][i].getText().isEmpty() ){
                winLogic(board[0][i].getText());

            }
        }
        //Horizontal
        for(int i = 0; i < 3; i++){
            if(board[i][0].getText().equals(board[i][1].getText()) && board[i][1].getText().equals(board[i][2].getText()) && board[i][2].getText().equals(board[i][0].getText()) && !board[i][0].getText().isEmpty() ){
                winLogic(board[0][i].getText());
            }
        }
        //Diagonals

        if(board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && board[2][2].getText().equals(board[0][0].getText()) && !board[0][0].getText().isEmpty() ){
            winLogic(board[0][0].getText());
        }

        if(board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) && board[2][0].getText().equals(board[0][2].getText()) && !board[0][2].getText().isEmpty() ){
            winLogic(board[0][2].getText());
        }

        if(moveCount == 9 && !won){
            System.out.println("Draw");
            moveCount = 0;
        }

    }
    public void winLogic(String player){
        won = true;
        moveCount = 0;
        lockAllBtn();
        System.out.println(player);
        if(player.equals("X")){
            Xscore++;
            System.out.println("X wins");
        }else{
            Oscore++;
            System.out.println("O wins!");
        }
    }
    public void lockAllBtn(){
        for(JButton button : buttons){
            button.setEnabled(false);
        }
    }
    class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            for(JButton button : buttons){
                if(button == e.getSource()){
                    button.setText(String.valueOf(currentChar));
                    button.setEnabled(false);
                    checkWin();
                    currentChar = (currentChar == 'X') ? 'O' : 'X';
                }
            }
        }

    }


}