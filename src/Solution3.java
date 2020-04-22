/**
 * Solution3
 */
public class Solution3 {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
  }

  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      int[] map = new int[128];
      int max = 0;
      int left = 0;
      int right = 0;
      while (right < s.length()) {
        char c = s.charAt(right);
        map[c]++;
        right++;
        while (map[c] > 1) {
          map[s.charAt(left)]--;
          left++;
        }

        max = Math.max(max, right - left);

      }

      return max;
    }
  }
}