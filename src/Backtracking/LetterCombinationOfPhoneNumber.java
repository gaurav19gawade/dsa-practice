package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

  HashMap<Character, String> digitToLetters = new HashMap<>();
  List<String> result = new ArrayList<>();
  StringBuffer sb = new StringBuffer();

  public List<String> letterCombinations(String digits) {
    if(digits == "" || digits.isEmpty()){
      return result;
    }


    digitToLetters.put('2', "abc");
    digitToLetters.put('3', "def");
    digitToLetters.put('4', "ghi");
    digitToLetters.put('5', "jkl");
    digitToLetters.put('6', "mno");
    digitToLetters.put('7', "pqrs");
    digitToLetters.put('8', "tuv");
    digitToLetters.put('9', "wxyz");

    dfs(digits, 0);

    return result;
  }


  public void dfs(String digits, int index){
    if(index == digits.length()){
      result.add(sb.toString());
      return;
    }

    String currentWord = digitToLetters.get(digits.charAt(index));

    for(char c: currentWord.toCharArray()){
      sb.append(c + "");
      dfs(digits, index + 1);
      sb.deleteCharAt(sb.length()-1);
    }
  }

  public static void main(String[] args){
    LetterCombinationOfPhoneNumber lcp = new LetterCombinationOfPhoneNumber();
    lcp.letterCombinations("23");
  }
}
