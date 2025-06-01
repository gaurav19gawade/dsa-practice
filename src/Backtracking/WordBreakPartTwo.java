package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreakPartTwo {

  HashMap<Integer, List<String>> map = new HashMap<>();
  public List<String> wordBreak(String s, List<String> wordDict) {
    return dfs(0, s, wordDict);
  }

  public List<String> dfs(int index, String originalWord, List<String> wordDict){
    if(map.containsKey(index)){
      return map.get(index);
    }


    List<String> result = new ArrayList<>();

    if(index == originalWord.length()){
      result.add("");
      return result;
    }

    for(String word: wordDict){
      int length = index + word.length();
      if(length <= originalWord.length()){
        String subStringOfOgWord = originalWord.substring(index, length);

        if(subStringOfOgWord.equals(word)){
          List<String> sentence = dfs(length, originalWord, wordDict);
          for(String sntce: sentence){
            String space = sntce.isEmpty() ? "": " ";
            result.add(word + space + sntce);
          }
        }
      }
    }

    map.put(index, result);
    return result;
  }

  public static void main(String[] args){
    WordBreakPartTwo wb = new WordBreakPartTwo();
    wb.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog"));
  }
}
