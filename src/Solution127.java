import java.util.*;

public class Solution127 {
  public static void main(String[] args) {
    List<String> wordList =
        new ArrayList<>(Arrays.asList(new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    System.out.println(new Solution().ladderLength("hit", "cog", wordList));
  }

  static class Solution {
    /**
     * Intuition:
     * - Preprocess wordList so we can map nodes that differ by 1 char together
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Map<String, List<String>> map = new HashMap<>();
      int L = beginWord.length();

      // O(N*M^2) time
      wordList.forEach(word -> {
        for (int i = 0; i < L; i++) { // O(M)
          String key = word.substring(0, i) + '*' + word.substring(i + 1, L); // O(M)
          List<String> set = map.getOrDefault(key, new ArrayList<>());
          set.add(word);
          map.put(key, set);
        }
      });
      System.out.println(map);

      Deque<String> queue = new ArrayDeque<>();
      Set<String> visited = new HashSet<>();
      int level = 0;
      queue.add(beginWord);
      visited.add(beginWord);

      // O(N*M^2) time, since we process N nodes in worst case.
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          String cur = queue.remove();
          if (cur.equals(endWord)) return level + 1;
          for (int j = 0; j < L; j++) { // O(M)
            String key = cur.substring(0, j) + '*' + cur.substring(j + 1, L); // O(M)
            for (String adj: map.getOrDefault(key, new ArrayList<>())) {
              if (!visited.contains(adj)) {
                visited.add(adj);
                queue.add(adj);
              }
            }
          }
        }
        level++;
      }
      return 0;
    }


    /**
     * Intuition:
     * - Treat question as a graph
     * - Generate adjList that connect words (nodes) that differ by 1 char together using edges.
     * - Starting at beginWord, use BFS to reach endWord
     * 
     * M = length of word
     * N = number of words
     * O(M*N^2) time
     * O(N^2) space
     * 
     * This is the least efficient solution since in general we expect N to be much larger than M.
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
      wordList.add(beginWord);
      int wordLen = beginWord.length();
      int beginIndex = wordList.size() - 1;
      int endIndex = wordList.indexOf(endWord); // O(N*M) time
      if (endIndex == -1)
        return 0;
      List<Integer>[] adj = new List[wordList.size()];
      for (int i = 0; i < adj.length; i++)
        adj[i] = new ArrayList<>();

      // O(N^2*M) time for this block
      // O(N^2) space in adj list in worst case.
      for (int i = 0; i < wordList.size(); i++) {
        for (int j = i + 1; j < wordList.size(); j++) {
          if (check(wordList.get(i), wordList.get(j))) { // O(M) time
            adj[i].add(j);
            adj[j].add(i);
          }
        }
      }

      Deque<Integer> queue = new ArrayDeque<>();
      queue.add(beginIndex);
      boolean[] visited = new boolean[wordList.size()]; // O(N) space
      visited[beginIndex] = true;
      int level = 0;
      // O(V + E) time, which is O(N + N^2) in worst case.
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          int u = queue.remove();
          if (u == endIndex) {
            return level + 1;
          }

          for (int v : adj[u]) {
            if (!visited[v]) {
              visited[v] = true;
              queue.add(v);
            }
          }
        }
        level++;
      }
      return 0;
    }

    // O(M)
    private boolean check(String s, String t) {
      int i = 0;
      int count = 0;
      while (i < s.length()) {
        if (s.charAt(i) != t.charAt(i))
          count++;
        if (count > 1)
          return false;
        i++;
      }

      return true;
    }
  }
}
