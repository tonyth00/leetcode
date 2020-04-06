import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1048 {
  public static void main(String[] args) {
    System.out.println(new Solution().longestStrChain2(new String[] {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}));
  }

  static class Solution {
    /**
     * DP solution. Pro: Less space Con: sorting
     * Complexity: O(NlogN + NL^2)
     * @param words
     * @return
     */
    public int longestStrChain(String[] words) {
      Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
      
      Map<String, Integer> map = new HashMap<>();
      int max = 0;
      for (String word : words) {
        int currentMax = 0;
        for (int i = 0; i < word.length(); i++) {
          String sub = word.substring(0, i) + word.substring(i + 1);
          currentMax = Math.max(currentMax, map.getOrDefault(sub, 0) + 1);
        }
        map.put(word, currentMax);
        max = Math.max(max, currentMax);
      }
      System.out.println(map);
      return max;
    }

    /**
     * DFS solution. Pro: no sorting, Con: more space for HashSet
     * @param words
     * @return
     */
    public int longestStrChain2(String[] words) {
      int max = 0;
      Map<String, Integer> map = new HashMap<>();
      Set<String> set = new HashSet<>();
      for (String word : words) {
        set.add(word);
      }
      for (String word : words) {
        max = Math.max(max, dfs(word, map, set));
      }

      return max;
    }

    private int dfs(String word, Map<String, Integer> map, Set<String> set) {
      if (map.containsKey(word)) return map.get(word);

      int max = 1;
      for (int i = 0; i < word.length(); i++) {
        String sub = word.substring(0, i) + word.substring(i + 1);
        if (set.contains(sub)) max = Math.max(max, dfs(sub, map, set) + 1); 
      }
      map.put(word, max);

      return max;
    }
  }
}