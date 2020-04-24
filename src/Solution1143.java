/**
 * Solution1143
 */
public class Solution1143 {

  public static void main(String[] args) {
    System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
  }

  static class Solution {
    /**
     * Intution: Assume two strings of arbitrary length X and Y. Focus on the last character of both strings -
     * If they're the same, remove them both and solve LCS(X-1, Y-1) - If they're not the same, take
     * the maximum of either LCS(X, Y-1) or LCS(X-1, Y-1) DP[i][j] = DP[i-1][j-1] + 1 if same =
     * max(DP[i][j-1],DP[i-1][j] otherwise
     */
    public int longestCommonSubsequence(String str1, String str2) {
      int m = str1.length();
      int n = str2.length();

      int[][] dp = new int[m + 1][n + 1];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          boolean same = str1.charAt(i) == str2.charAt(j);
          dp[i + 1][j + 1] = same ? 1 + dp[i][j] : 1 + Math.max(dp[i][j + 1], dp[i + 1][j]);
        }
      }

      return dp[m][n];
    }
  }
}
