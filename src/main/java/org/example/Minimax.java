package org.example;

import javax.swing.*;

public class Minimax {

    public int evaluate(JButton[][] board, int depth, float alpha, float beta, boolean maximizingPlayer) {
        int result = checkWin(board);
        if (result != 0) {
            return result;
        }

        if (depth == 9 || checkDraw(board)) {
            return 0;
        }

        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].getText().isEmpty()) {
                        board[i][j].setText("O");
                        int eval = evaluate(board, depth + 1, alpha, beta, false);
                        board[i][j].setText("");
                        maxEval = Math.max(maxEval, eval);
                        alpha = Math.max(alpha, eval);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].getText().isEmpty()) {
                        board[i][j].setText("X");
                        int eval = evaluate(board, depth + 1, alpha, beta, true);
                        board[i][j].setText("");
                        minEval = Math.min(minEval, eval);
                        beta = Math.min(beta, eval);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return minEval;
        }
    }

    public int checkWin(JButton[][] board) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText().equals(board[i][1].getText()) &&
                    board[i][1].getText().equals(board[i][2].getText()) &&
                    !board[i][0].getText().isEmpty()) {
                return board[i][0].getText().equals("X") ? -1 : 1;
            }
            if (board[0][i].getText().equals(board[1][i].getText()) &&
                    board[1][i].getText().equals(board[2][i].getText()) &&
                    !board[0][i].getText().isEmpty()) {
                return board[0][i].getText().equals("X") ? -1 : 1;
            }
        }

        // Check diagonals
        if (board[0][0].getText().equals(board[1][1].getText()) &&
                board[1][1].getText().equals(board[2][2].getText()) &&
                !board[0][0].getText().isEmpty()) {
            return board[0][0].getText().equals("X") ? -1 : 1;
        }
        if (board[0][2].getText().equals(board[1][1].getText()) &&
                board[1][1].getText().equals(board[2][0].getText()) &&
                !board[0][2].getText().isEmpty()) {
            return board[0][2].getText().equals("X") ? -1 : 1;
        }

        return 0; // No winner yet
    }

    public boolean checkDraw(JButton[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
