package org.example;

import javax.swing.*;

public class Minimax {

    public float evaluate(JButton[][] board, int depth, float alpha, float beta, boolean maximizingPlayer){
        //TODO: Base Case, create a function that returns 0 if draw, 1 if X wins, -1 if O wins


        if(depth == 0){
            //TODO: Check for win
            return 0;
        }
        if(maximizingPlayer){
            float maxEval = Float.NEGATIVE_INFINITY;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j].getText().isEmpty()){
                        board[i][j].setText("O");
                        float eval = evaluate(board, depth -1, alpha, beta, false);
                        maxEval = Math.max(maxEval, eval);
                        alpha = Math.max(alpha, eval);
                        if(beta <= alpha){
                            break;
                        }
                    }
                }
            }
            System.out.println("max eval: " +maxEval);
            return maxEval;

        }else{
            float minEval = Float.POSITIVE_INFINITY;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; i++){
                    if(board[i][j].getText().isEmpty()){
                        board[i][j].setText("X");
                        float eval = evaluate(board, depth - 1, alpha, beta, true);
                        minEval = Math.min(minEval, eval);
                        beta = Math.min(beta, eval);
                        if(beta <= alpha){
                            break;
                        }

                    }

                }
            }
            System.out.println("Min eval: " + minEval);
            return minEval;


        }
    }
}
