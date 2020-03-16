import shared.Helper;

/**
 * Solution1143
 */
public class Solution1143 {

  public static void main(String[] args) {
    System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
  }

  static class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
      if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
        return 0;
      int m = str1.length();
      int n = str2.length();
      if (m > n)
        return longestCommonSubsequence(str2, str1);

      // int[] C1 = new int[m + 1];
      // int[] C2 = new int[m + 1];

      int[][] C = new int[2][m + 1];

      for (int j = 1; j <= n; j++) {
        for (int i = 1; i <= m; i++) {
          if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            C[j % 2][i] = C[(j - 1) % 2][i - 1] + 1;
          } else {
            C[j % 2][i] = Math.max(C[j % 2][i - 1], C[(j - 1) % 2][i]);
          }
        }
      }

      return C[n % 2][m];
    }
  }
}