import java.util.HashMap;

/**
 * Solution3
 */
public class Solution3 {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstring("abba"));
  }

  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s == null)
        return 0;
      int max = 0;

      HashMap<Character, Integer> map = new HashMap<>();
      for (int left = 0, right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        if (map.containsKey(c)) {
          left = Math.max(left, map.get(c) + 1);
        }

        map.put(c, right);
        max = Math.max(max, right - left + 1);
      }

      return max;
    }
  }
}