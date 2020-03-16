/**
 * Solution647
 */
public class Solution647 {

  public static void main(String[] args) {
    System.out.println(new Solution().countSubstrings("aaa"));
  }

  static class Solution {
    public int countSubstrings(String s) {
      if (s == null || s.length() == 0) return 0;

      int count = 0;
      for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j <= 1; j++) {
          int left = i;
          int right = i + j;
          while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
          }
        }
      }
      return count;

    }
  }
}