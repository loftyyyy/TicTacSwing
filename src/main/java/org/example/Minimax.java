package org.example;

import javax.swing.*;

public class Minimax {
    private JButton[][] board;
    private int depth;
    private float alpha;
    private float beta;
    private boolean maximizingPlayer;

    public Minimax(JButton[][] board, int depth, float alpha, float beta, boolean maximizingPlayer){
        this.board = board;
        this.depth = depth;
        this.alpha = alpha;
        this.beta =  beta;
        this.maximizingPlayer = maximizingPlayer;

    }
    public float evaluate(){
        if(depth == 0){
            return 0;
        }
        if(maximizingPlayer){
            float maxEval = Float.NEGATIVE_INFINITY;


        }else{
            float minEval = Float.POSITIVE_INFINITY;

        }
        return 0;
    }
}
