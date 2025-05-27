package graphs;


/*
Given a begin word and a target word we need to figure out how many transformation would it take to
reach the end word and that during transformation we also need to check if that word is part of Word set.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {


  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> dictionary = new HashSet<>(wordList);
    Queue<String> queue = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();

    if (!dictionary.contains(endWord)) {
      return 0;
    }
    queue.add(beginWord);
    visited.add(beginWord);
    int levels = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        char[] currentWord = queue.poll().toCharArray();

        for (int j = 0; j < currentWord.length; j++) {
          char temp = currentWord[j];
          for (char c = 'a'; c <= 'z'; c++) {
            currentWord[j] = c;
            String curr = new String(currentWord);

            if (endWord.equals(curr)) {
              return levels + 1;
            }

            if (dictionary.contains(curr) && !visited.contains(curr)) {
              queue.offer(curr);
              visited.add(curr);
            }

          }
          currentWord[j] = temp;
        }
      }
      levels++;
    }
    return 0;
  }
}
