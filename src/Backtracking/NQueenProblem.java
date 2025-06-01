package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

  List<List<String>> result = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    int[][] board = new int[n][n];
    solveNQueen(0, board);
    return result;
  }

  public void solveNQueen(int row, int[][] board) {
    if (row == board.length) {
      //construct board
      result.add(construct(board));
    }

    for (int col = 0; col < board.length; col++) {
      if (isSafe(row, col, board)) {
        board[row][col] = 1;
        solveNQueen(row + 1, board);
        board[row][col] = 0;
      }
    }
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

  private List<String> construct(int[][] board) {
    List<String> rowList = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 0) {
          sb.append(".");
        } else {
          sb.append("Q");
        }
      }
      rowList.add(sb.toString());
    }
    return rowList;
  }

}
