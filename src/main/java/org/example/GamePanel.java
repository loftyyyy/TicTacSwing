package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel(String gameMode) {
        if(gameMode.equals("PvP")){
            new TicTacToeClassic();

        }else{
            new TicTacToeAI();

        }
    }
}
