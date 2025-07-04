package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CourseSchedule {
  /*
  We have list of courses, where in order to complete a course we need to complete its pre-reqs
  for eg - [[0,1]] to complete course 1 you need to complete course 0
  Return whether courses can be completed or not
   */

  public boolean canFinish(int numCourses, int[][] prerequisites){
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
          return false;
        }
      }
    }

    return true;
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
    return false;
  }

  public static void main(String[] args){
    System.out.println("Print");
  }
}