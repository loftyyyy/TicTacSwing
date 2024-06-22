package org.example;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;

public class Minimax {

    public int evaluate(JButton[][] board, int depth, float alpha, float beta, boolean maximizingPlayer){
        //TODO: Base Case, create a function that returns 0 if draw, 1 if X wins, -1 if O wins


//        if(depth == 0){
//            //TODO: Check for win
//            return 0;
//        }
        if(maximizingPlayer){
            int maxEval = Integer.MIN_VALUE;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j].getText().isEmpty()){
                        board[i][j].setText("O");
                        int eval = evaluate(board, depth - 1, alpha, beta, false);
                        board[i][j].setText("");
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
            int minEval = Integer.MAX_VALUE;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; i++){
                    if(board[i][j].getText().isEmpty()){
                        board[i][j].setText("X");
                        int eval = evaluate(board, depth - 1, alpha, beta, true);
                        board[i][j].setText("");
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
