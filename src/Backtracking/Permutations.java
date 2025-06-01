package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> permute(int[] nums) {
    boolean[] used = new boolean[nums.length];

    dfs(used, nums, new ArrayList<>());
    return result;
  }

  public void dfs(boolean[] used, int[] nums, List<Integer> combination){
    if(combination.size() == nums.length){
      result.add(new ArrayList<>(combination));
      return;
    }

    for(int i = 0; i < nums.length; i++){
      if(used[i]) continue;

      combination.add(nums[i]);
      used[i] = true;
      dfs(used, nums, combination);
      used[i] = false;
      combination.remove(combination.size()-1);
    }
  }

  public static void main(String[] args){
    Permutations perm = new Permutations();
    perm.permute(new int[]{1,2,3});
  }
}
