
public class Solution159 {
  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("eceba"));
  }

  static class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
      int left = 0;
      int right = 0;

      int count = 0;
      int[] map = new int[128];
      int max = 0;
      while (right < s.length()) {
        char c = s.charAt(right);
        if (map[c] == 0) count++;
        map[c]++;
        right++;

        while (count > 2) {
          char d = s.charAt(left);
          map[d]--;
          if (map[d] == 0) count--;
          left++;
        }

        max = Math.max(max, right - left);
      }
      return max;
    }
  }
}
