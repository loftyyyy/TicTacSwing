package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    public MainMenuPanel(JFrame frame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton pvpButton = new JButton("Player vs Player");
        JButton aiButton = new JButton("Player vs AI");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pvpButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(aiButton, gbc);

        // Add action listeners to the buttons
        pvpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new GamePanel("PvP"));
                frame.revalidate();
                frame.repaint();
            }
        });

        aiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(new GamePanel("AI"));
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}
