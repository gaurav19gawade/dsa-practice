package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
  StringBuilder sb = new StringBuilder();
  List<String> result = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    dfs(0,0,n);
    return result;
  }

  public void dfs(int open, int close, int n){
    if(open == n && close == n){
      result.add(sb.toString());
      return;
    }

    if(open < n){
      sb.append("(");
      dfs(open+1, close, n);
      sb.deleteCharAt(sb.length()-1);
    }

    if(close < open){
      sb.append(")");
      dfs(open, close+1, n);
      sb.deleteCharAt(sb.length()-1);
    }
  }
}
