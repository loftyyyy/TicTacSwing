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
    private JButton[][] button2d = new JButton[3][3];
    public static void main(String[] args) {
        new TicTacToe().startGUI();

    }
    public void startGUI(){
        JFrame window = new JFrame("Tic Tac Toe Nigga");
        JPanel buttonPanel = new JPanel(new GridLayout(3,3));
        JPanel controlPanel = new JPanel();

        for(int i = 0; i < 9;i++){
            JButton button = new JButton();
//            button.setPreferredSize();
            button.setFocusPainted(false);
            button.setFont(new Font("Lato", Font.PLAIN, 120));
            button.setBackground(Color.decode("#F5E7B2"));
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.addActionListener(new ButtonActionListener());
            buttons.add(button);
            buttonPanel.add(button);
        }
        JButton clearButton = new JButton("Clear Table");
        clearButton.addActionListener(e -> buttons.stream().forEach(button -> {button.setText("");button.setEnabled(true);}));

        controlPanel.add(clearButton);

        window.getContentPane().add(BorderLayout.CENTER, buttonPanel);
        window.getContentPane().add(BorderLayout.SOUTH, controlPanel);

        window.setSize(500,700);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);



    }
    class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            for(JButton button : buttons){
                if(button == e.getSource()){
                    button.setText(String.valueOf(currentChar));
                    button.setEnabled(false);
                    currentChar = (currentChar == 'X') ? 'O' : 'X';
                }
            }
        }

    }


}