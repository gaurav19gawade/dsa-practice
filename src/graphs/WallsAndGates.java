package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

  /*
    in this 2D matrix which identifies rooms.
    -1 is wall or obstacle
    0 is a gate
    INF is an empty room.
    Fill each room with the distance to its nearest gate
   */

  public void wallsAndGates(int[][] rooms) {
    Queue<int[]> queue = new LinkedList<>();
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    for(int row = 0; row < rooms.length; row++){
      for(int col = 0; col < rooms[0].length; col++){
        if(rooms[row][col] == 0){
          queue.offer(new int[]{row, col});
        }
      }
    }

    while(!queue.isEmpty()){
      int[] currentRoom = queue.poll();

      for(int[] direction: directions){
        int newRow = direction[0] + currentRoom[0];
        int newCol = direction[1] + currentRoom[1];

        if(newRow >= 0 && newRow < rooms.length && newCol >=0 && newCol < rooms[0].length && rooms[newRow][newCol] == Integer.MAX_VALUE){
          rooms[newRow][newCol] = rooms[currentRoom[0]][currentRoom[1]] + 1;
          queue.offer(new int[]{newRow, newCol});
        }
      }
    }
  }
}
