import java.util.Arrays;
public class Solution132 {
  public static void main(String[] args) {
    System.out.println(new Solution().minCut("aab"));
  }

  static class Solution {

    /**
     * Intuition:
     * From Problem 5, use expand around center method to find all palindromes of a string.
     * This is the fastest way to check for all palindromes in a string because:
     * If s.substring(i, j) is a palindrome, to check s.substring(i - 1, j + 1) we only need to
     * check if s[i - 1] == s[j + 1] since we have prior knowledge of shorter substring.
     * 
     * If during expansion we find a palindrome at [i, j], we make a cut to the left of the palindrome,
     * take dp[i - 1] (which is the minimum solution to the i - 1 problem), add 1 for the cut, and 
     * update dp[j].
     * 
     * expandAround() has O(n) time, and we loop through this n times. Therefore time complexity is O(n^2)
     */
    public int minCut(String s) {
      char[] ch = s.toCharArray();

      int[] dp = new int[ch.length + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = -1;

      for (int i = 0; i < ch.length; i++) {
        expandAround(ch, i, i, dp);
        expandAround(ch, i, i + 1, dp);
      }
      return dp[ch.length];
    }

    private void expandAround(char[] ch, int i, int j, int[] dp) {
      while (i >= 0 && j < ch.length && ch[i] == ch[j]) {
        dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
        i--;
        j++;
      }
    }
    /**
     * Brute force O(n^3)
     * Intuition:
     * We use DP strategy by gradually increasing the length of the string
     * For each string, we arbitrarily cut the string at i (between 0 and j),
     * check RHS if it's a palindrome, and if it is, update the current dp index.
     * 
     * It is O(n^3) because we are making 1+2+3+...+n cuts => O(n^2)
     * and for each cut, we're performing isPalindrome() which is a O(n) function.
     */
    public int minCut2(String s) {
      int[] dp = new int[s.length() + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = -1;
      char[] ch = s.toCharArray();
      for (int j = 0; j < ch.length; j++) {
        for (int i = 0; i <= j; i++) {
          if (isPalindrome(ch, i, j)) {
            dp[j + 1] = Math.min(dp[j + 1], 1 + dp[i]);
          }
        }
      }

      return dp[s.length()];
    }

    private boolean isPalindrome(char[] ch, int i, int j) {
      while (i < j) {
        if (ch[i++] != ch[j--]) return false;
      }

      return true;
    }
  }
}
