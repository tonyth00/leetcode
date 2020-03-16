import java.util.HashMap;

/**
 * Solution76
 */
public class Solution76 {

  public static void main(String[] args) {
    System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
  }

  static class Solution {
    public String minWindow(String s, String t) {
      if (s == null || t == null || t.length() > s.length())
        return "";

      HashMap<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < t.length(); i++) {
        map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
      }

      int minLeft = 0;
      int minRight = s.length() + 1;
      int count = 0;
      for (int left = 0, right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        if (map.containsKey(c)) {
          map.put(c, map.get(c) - 1);

          if (map.get(c) >= 0) {
            count++;

            while (count == t.length()) {
              if (minRight - minLeft > right - left) {
                minRight = right;
                minLeft = left;
              }

              char L = s.charAt(left);
              if (map.containsKey(L)) {
                map.put(L, map.get(L) + 1);
                if (map.get(L) > 0)
                  count--;
              }
              left++;
            }
          }
        }
      }

      return minRight == s.length() + 1 ? "" : s.substring(minLeft, minRight + 1);
    }
  }
}