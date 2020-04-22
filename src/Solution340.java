
public class Solution340 {
  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstringKDistinct("eceba", 2));

  }

  static class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      int left = 0;
      int right = 0;
      int count = 0;
      int max = 0;
      int[] map = new int[128];
      while (right < s.length()) {
        char c = s.charAt(right);
        if (map[c] == 0) count++;
        map[c]++;
        right++;
        
        while (count > k) {
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
