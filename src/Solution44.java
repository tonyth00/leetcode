
public class Solution44 {
  public static void main(String[] args) {
    System.out.println(new Solution().isMatch("adceb", "*a*b"));
  }

  static class Solution {
    public boolean isMatch(String s, String p) {
      int m = s.length();
      int n = p.length();
      boolean dp[][] = new boolean[m + 1][n + 1];
      dp[0][0] = true;
      for (int j = 1; j <= n; j++) {
        if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
      }

      for (int i = 1; i <= m; i++) {
        char sChar = s.charAt(i - 1);
        for (int j = 1; j <= n; j++) {
          char pChar = p.charAt(j - 1);
          if (sChar == pChar || pChar == '?') {
            dp[i][j] = dp[i - 1][j - 1];
          } else if (pChar == '*') {
            dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
          }
        }
      }
      return dp[m][n];
    }
  }
}