package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblemPartTwo {

  public int totalNQueens(int n) {
    int[][] board = new int[n][n];
    return solveNQueen(0, board);
  }

  public int solveNQueen(int row, int[][] board) {
    if (row == board.length) {
      return 1;
    }

    int count = 0;

    for (int col = 0; col < board.length; col++) {
      if (isSafe(row, col, board)) {
        board[row][col] = 1;
        count += solveNQueen(row + 1, board);
        board[row][col] = 0;
      }
    }
    return count;
  }

  public boolean isSafe(int row, int col, int[][] board) {

    //check for all columns in same row
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 1) {
        return false;
      }
    }

    //upper left diagonal check
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    //upper right diagonal check
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true;
  }
}
