package graphs;

public class NumberOfIslands {

  /*
  In a 2D matrix a group of 1s represent 1 island, we need to find number of islands
   */

  public int numIslands(char[][] grid){
    int numberOfIslands = 0;

    for(int row = 0; row < grid.length; row++){
      for(int col = 0; col < grid[0].length; col++){
        if(grid[row][col] == '1'){
          dfs(row, col, grid);
          numberOfIslands++;
        }
      }
    }

    return numberOfIslands;
  }

  public void dfs(int row, int col, char[][] grid){
    grid[row][col] = '0';

    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    for(int[] dir: directions){
      int newRow = dir[0] + row;
      int newCol = dir[1] + col;

      if(newRow >=0 && newRow < grid.length && newCol >=0 && newCol < grid[0].length && grid[newRow][newCol] == '1'){
        dfs(newRow, newCol, grid);
      }
    }
  }



}
