package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetPartTwo {
  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    dfs(nums, 0, false, new ArrayList<>());
    return result;
  }

  public void dfs(int[] nums, int index, boolean isPickedPrev, List<Integer> subset){
    if(index == nums.length){
      result.add(new ArrayList<>(subset));
      return;
    }

    dfs(nums, index+1, false, subset);

    //If the current number is the same as the previous one, and the previous one was not picked, then skip this branch

    if(index > 0 && nums[index] == nums[index-1] && !isPickedPrev){
      return;
    }

    subset.add(nums[index]);
    dfs(nums, index + 1, true, subset);
    subset.remove(subset.size()-1);
  }
}
