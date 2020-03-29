import java.util.*;
import shared.*;

class Solution269 {
  public static void main(String[] args) {
    String[] words = {"za", "zb", "ca", "cb"};
    // String[] words = {"z", "x", "z"};
    System.out.println(new Solution().alienOrder(words));
  }

  static class Solution {
    public String alienOrder(String[] words) {
      Map<Character, List<Character>> adj = new HashMap();
      for (String word : words) {
        for (int i = 0; i < word.length(); i++) {
          adj.putIfAbsent(word.charAt(i), new LinkedList<>());
        }
      }

      if (!buildGraph(words, adj)) return "";

      int[] inDegree = new int[26];
      for (List<Character> list : adj.values()) {
        for (char v : list) inDegree[v - 'a']++;
      }

      StringBuilder sb = new StringBuilder();
      Queue<Character> queue = new LinkedList<>();
      for (char u : adj.keySet()) {
        if (inDegree[u - 'a'] == 0) queue.add(u);
      }
      while (!queue.isEmpty()) {
        char u = queue.remove();
        sb.append(u);
        for (char v : adj.get(u)) {
          inDegree[v - 'a']--;
          if (inDegree[v - 'a'] == 0) queue.add(v);
        }
      }

      if (sb.length() != adj.size()) return "";

      return sb.toString();
    }

    private boolean buildGraph(String[] words, Map<Character, List<Character>> adj) {
      for (int i = 0; i < words.length - 1; i++) {
        String w1 = words[i];
        String w2 = words[i + 1];

        int len = Math.min(w1.length(), w2.length());
        for (int j = 0; j < len; j++) {
          char c1 = w1.charAt(j);
          char c2 = w2.charAt(j);

          if (c1 == c2) {
            if (j == len - 1 && w1.length() > w2.length()) return false;
          } else {
            if (!adj.get(c1).contains(c2)) {
              adj.get(c1).add(c2);
            }
            break;
          }
        }
      }
      return true;
    }

    // public String alienOrder(String[] words) {
    //   Map<Character, List<Character>> adj = new HashMap();
    //   for (String word : words) {
    //     for (int i = 0; i < word.length(); i++) {
    //       adj.putIfAbsent(word.charAt(i), new LinkedList<>());
    //     }
    //   }
    //   if (!buildGraph(words, adj)) return "";

    //   StringBuilder sb = new StringBuilder();
    //   Set<Character> visited = new HashSet<>();
    //   for (char c : adj.keySet()) {
    //     if (!dfs(adj, c, visited, new HashSet<>(), sb)) return "";
    //   }

    //   return sb.reverse().toString();
    // }

    private boolean dfs(Map<Character, List<Character>> adj, char u, Set<Character> visited, Set<Character> current, StringBuilder sb) {
      if (visited.contains(u)) return true;
      visited.add(u);
      for (char v : adj.get(u)) {
        if (current.contains(v)) return false;
        current.add(u);
        if (!dfs(adj, v, visited, current, sb)) return false;
        current.remove(u);
      }

      sb.append(u);

      return true;
    }
    
  }
}