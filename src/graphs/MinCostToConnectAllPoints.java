package graphs;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
/*
You are given a 2D array which each index indicates a point on 2D plane. The plan is to connect all
the points by calculating minimum distance between points using Manhattan distance.
 */

  static class Point {
    int index;
    int distance;

    Point(int index, int distance){
      this.index = index;
      this.distance = distance;
    }
  }


  public int minCostConnectPoints(int[][] points) {
    int minCost = 0;
    HashSet<Integer> visited = new HashSet<>();
    PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.distance, b.distance));
    pq.offer(new Point(0,0));

    while(!pq.isEmpty() && visited.size() < points.length){
      Point currentPoint = pq.poll();
      int[] currentCoords = points[currentPoint.index];

      if(visited.contains(currentPoint.index)) continue;

      minCost += currentPoint.distance;
      visited.add(currentPoint.index);

      for(int i =0; i < points.length; i++){
        if(!visited.contains(i)){
          int distance = Math.abs(points[i][0] - currentCoords[0]) + Math.abs(points[i][1] - currentCoords[1]);
          pq.offer(new Point(i, distance));
        }
      }
    }
    return minCost;
  }

  public static void main(String[] args){
    MinCostToConnectAllPoints mcp = new MinCostToConnectAllPoints();
    System.out.println(mcp.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
  }
}
