import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Solution30
 */
public class Solution30 {

  public static void main(String[] args) {
    System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }));
  }

  static class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> res = new ArrayList<>();

      if (words == null || s == null || words.length == 0 || words[0].length() == 0)
        return res;

      int m = words.length;
      int n = words[0].length();

      HashMap<String, Integer> map = new HashMap<>();
      for (String str : words) {
        map.put(str, map.getOrDefault(str, 0) + 1);
      }

      for (int i = 0; i <= s.length() - m * n; i++) {
        HashMap<String, Integer> dup = new HashMap<>(map);
        boolean found = true;
        for (int k = i; k < i + m * n; k += n) {
          String sub = s.substring(k, k + n);
          int count = dup.getOrDefault(sub, 0);
          if (count > 0) {
            dup.put(sub, count - 1);
          } else {
            found = false;
            break;
          }
        }

        if (found) {
          res.add(i);
        }
      }
      return res;
    }
  }
}