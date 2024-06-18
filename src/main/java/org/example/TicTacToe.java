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
            button.setFont(new Font("Lato", Font.PLAIN, 160));
            button.setBackground(Color.decode("#F5E7B2"));
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setVerticalAlignment(SwingConstants.CENTER);
            button.addActionListener(new ButtonActionListener());
            buttons.add(button);
            buttonPanel.add(button);
        }

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
                    button.setText("x");

                }


            }
        }


    }
    class MouseActionListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            System.out.println("released");
        }
    }

}