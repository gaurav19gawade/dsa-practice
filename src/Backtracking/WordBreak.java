package Backtracking;

import java.util.HashSet;
import java.util.List;

public class WordBreak {

  HashSet<Integer> cache = new HashSet<>();
  public boolean wordBreak(String s, List<String> wordDict) {
    return dfs(0, wordDict, s);
  }

  public boolean dfs(int index, List<String> wordDict, String originalWord){
    if(index == originalWord.length()){
      return true;
    }

    if(cache.contains(index)){
      return false;
    }

    for(String word: wordDict){
      int length = index + word.length();
      if(length <= originalWord.length()){
        String subStringOfOgWord = originalWord.substring(index, length);
        if(subStringOfOgWord.equals(word)){
          if(dfs(length, wordDict, originalWord)){
            return true;
          }
        }
      }
    }
    cache.add(index);
    return false;
  }

  public static void main(String[] args){
    WordBreak wb = new WordBreak();
    wb.wordBreak("leetcode", List.of("leet", "code"));
  }


}
