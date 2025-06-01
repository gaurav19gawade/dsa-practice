package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    dfs(nums, new ArrayList<>(), 0);
    return result;
  }

  public void dfs(int[] nums, List<Integer> subset, int index){
    if(index == nums.length){
      result.add(new ArrayList<>(subset));
      return;
    }

    subset.add(nums[index]);
    dfs(nums, subset, index+1);

    subset.remove(subset.size()-1);
    dfs(nums, subset, index+1);

  }
}
