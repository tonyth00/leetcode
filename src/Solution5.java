/**
 * Solution5
 */
public class Solution5 {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("a"));
  }

  static class Solution {
    public String longestPalindrome(String s) {
      if (s == null || s.length() == 0)
        return s;
      int maxLength = 0;
      int finalLeft = -1;
      int finalRight = -1;

      for (int i = 0; i <= s.length() - 1 - maxLength / 2; i++) {
        for (int j = i; j <= i + 1; j++) {
          int left = i;
          int right = j;
          while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int length = right - left + 1;
            if (length > maxLength) {
              maxLength = length;
              finalLeft = left;
              finalRight = right;
            }

            left--;
            right++;
          }

        }
      }

      return s.substring(finalLeft, finalRight + 1);
    }
  }
}