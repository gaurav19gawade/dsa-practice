package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> combine(int n, int k) {
    dfs(n,k,new ArrayList<>(), 1);
    return result;
  }

  public void dfs(int n, int k, List<Integer> combination, int start){
    if(combination.size() == k){
      result.add(new ArrayList<>(combination));
      return;
    }

    for(int i = start; i <= n; i++){
      combination.add(i);
      dfs(n, k, combination, i + 1);
      combination.remove(combination.size()-1);
    }
  }

  public static void main(String[] args){
    Combination comb = new Combination();
    comb.combine(4,2);
  }
}
