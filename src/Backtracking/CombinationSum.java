package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    dfs(candidates, target, new ArrayList<>(), 0);
    return result;
  }

  public void dfs(int[] candidates, int target, List<Integer> combination, int start){
    if(target == 0){
      result.add(new ArrayList<>(combination));
      return;
    }

    if(target < 0){
      return;
    }

    for(int i = start; i < candidates.length; i++){
      combination.add(candidates[i]);
      dfs(candidates, target - candidates[i], combination, i);
      combination.remove(combination.size()-1);
    }
  }

}
