package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

  List<List<String>> result = new ArrayList<>();

  public List<List<String>> partition(String s) {
    dfs(0, s, new ArrayList<>());
    return result;
  }

  public void dfs(int start, String s, List<String> palindrome){
    if(start == s.length()){
      result.add(new ArrayList<>(palindrome));
      return;
    }

    for(int i = start; i < s.length(); i++){
      if(isPalindrome(s.substring(start, i+1))){
        palindrome.add(s.substring(start, i+1));
        dfs(i+1, s, palindrome);
        palindrome.remove(palindrome.size()-1);
      }
    }
  }

  public boolean isPalindrome(String word){
    int left = 0;
    int right = word.length()-1;

    while(left < right){
      if(word.charAt(left) != word.charAt(right)){
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
