package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseScheduleII {

  List<Integer> path = new ArrayList<>();

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    boolean[] visited = new boolean[numCourses];
    boolean[] currentPath = new boolean[numCourses];


    for(int[] course: prerequisites){
      map.computeIfAbsent(course[1], key -> new ArrayList<>()).add(course[0]);
    }

    for(int i = 0; i < numCourses; i++){
      if(!visited[i]){
        //traverse using dfs
        if(hasCycle(visited, currentPath, i, map)){
          return new int[]{};
        }
      }
    }

    return path.stream().mapToInt(Integer::intValue).toArray();
  }

  public boolean hasCycle(boolean[] visited, boolean[] currentPath, int currentCourse, HashMap<Integer, List<Integer>> map){
    if(visited[currentCourse]) return false;
    if(currentPath[currentCourse]) return true;

    currentPath[currentCourse] = true;

    for(int course: map.getOrDefault(currentCourse, new ArrayList<>())){
      if(!visited[course]){
        if(hasCycle(visited, currentPath, course, map)){
          return true;
        }
      }
    }

    currentPath[currentCourse] = false;
    visited[currentCourse] = true;
    path.add(currentCourse);
    return false;
  }

  public static void main(String[] args){
    CourseScheduleII cs = new CourseScheduleII();
    System.out.println("Print");
  }
}
