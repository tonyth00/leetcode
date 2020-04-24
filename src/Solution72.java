
public class Solution72 {
  public static void main(String[] args) {
    System.out.println(new Solution().minDistance("horse", "ros"));
  }

  static class Solution {
    /**
     * Intuition
     * We have two strings x and y, and two pointers i and j representing
     * prefixes: x[i], y[j]. If x[i] == y[j] there's no editing involved.
     * If x[i] != y[j] we can obtain:
     * 1) replace x[i] -> y[j]
     * 2) insert y[j] 
     * 3) delete x[i] and insert/replace y[j] at a later point
     */
    public int minDistance(String word1, String word2) {
      int m = word1.length();
      int n = word2.length();
      char[] a = word1.toCharArray();
      char[] b = word2.toCharArray();
      int[][] dp = new int[m + 1][n + 1];
      for (int i = 0; i <= m; i++) dp[i][0] = i;
      for (int j = 0; j <= n; j++) dp[0][j] = j;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (a[i] == b[j]) {
            dp[i + 1][j + 1] = dp[i][j];
          } else {
            dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
          }
        }
      }
      return dp[m][n];
    }
  }
}
