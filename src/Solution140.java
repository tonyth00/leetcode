import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Solution140
 */
public class Solution140 {

  public static void main(String[] args) {
    System.out.println(new Solution().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
  }

  static class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
      Map<String, List<String>> used = new HashMap<>();
      Set<String> set = new HashSet<>(wordDict);
      List<String> res = helper(s, set, used);
      System.out.println(used);
      return res;
    }

    public List<String> helper(String s, Set<String> set, Map<String, List<String>> used) {
      if (used.containsKey(s)) {
        return used.get(s);
      }

      if (s.length() == 0)
        return null; // Reached end of the string
      List<String> res = new ArrayList<>();

      for (int i = 1; i <= s.length(); i++) {
        String sub = s.substring(0, i);
        if (set.contains(sub)) {
          List<String> partRes = helper(s.substring(i), set, used);
          if (partRes == null) {
            // reaches here when remaining substring is an empty string
            res.add(sub);
          } else {
            for (String parts : partRes) {
              res.add(sub + " " + parts);
            }
          }
        }
      }
      used.put(s, res);
      return res;
    }
  }
}