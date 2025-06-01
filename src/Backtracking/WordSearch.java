package Backtracking;

public class WordSearch {

  int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

  public boolean exist(char[][] board, String word) {

    for(int row = 0; row < board.length; row++){
      for(int col = 0; col < board[0].length; col++){
        if(board[row][col] == word.charAt(0)){
          if(dfs(word, board, 0, row, col)){
            return true;
          }
        }
      }
    }
    return false;
  }


  public boolean dfs(String word, char[][] board, int index, int row, int col){
    if(index == word.length()){
      return true;
    }

    if(row < 0  || row > board.length || col < 0 || col > board[0].length || board[row][col] != word.charAt(index)){
      return false;
    }

    char temp = board[row][col];
    board[row][col] = '#';

    for(int[] direction: directions){
      int newRow = direction[0] + row;
      int newCol = direction[1] + col;

      if(dfs(word, board, index+1, newRow, newCol)){
        return true;
      }
    }

    board[row][col] = temp;
    return false;
  }



  public static void main(String[] args){

  }
}
