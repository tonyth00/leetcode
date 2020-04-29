
public class Solution10 {
  public static void main(String[] args) {
    System.out.println(new Solution().isMatch("aab", "c*a*b"));
  }

  static class Solution {
    public boolean isMatch(String str, String pattern) {
      char[] s = str.toCharArray();
      char[] p = pattern.toCharArray();
      int m = s.length;
      int n = p.length;
      boolean[][] dp = new boolean[m + 1][n + 1];
      dp[0][0] = true;
      for (int j = 2; j <= n; j++) {
        if (p[j - 1] == '*') dp[0][j] = dp[0][j - 2];
      }

      for (int i = 1; i <= m; i++) {
        char sChar = s[i - 1];
        for (int j = 1; j <= n; j++) {
          char pChar = p[j - 1];
          if (sChar == pChar || pChar == '.') {
            dp[i][j] = dp[i - 1][j - 1];
          } else if (pChar == '*') {
            if (dp[i][j - 2]) dp[i][j] = dp[i][j - 2];
            else {
              if (sChar == p[j - 2] || p[j - 2] == '.') {
                dp[i][j] = dp[i - 1][j];
              }
            }
          }
        }
      }

      return dp[m][n];
    }
  }
}
