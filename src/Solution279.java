import java.util.Arrays;
public class Solution279 {
  public static void main(String[] args) {
    System.out.println(new Solution().numSquares(12));
  }

  static class Solution {
    /**
     * Intuition:
     * - This is really just a variation of the coin change problem
     * - Given coins 1, 4, 9, 16, 25, what's the minimum coins required to 
     * form the total n?
     * - dp[i] = minimum number of squared values to form the total i
     * Then we just simulate subtracting different squared values, and keeping
     * the minimum of those results. Easy.
     * dp[i] = min(dp[i - k^2]) + 1, where i - k^2 >= 0 starting at k = 1.
     * 
     * O(n*sqrt(n)) time
     * O(n) space
     */
    public int numSquares(int n) {
      int[] dp = new int[n + 1];
      Arrays.fill(dp, n + 1);
      dp[0] = 0;
      for (int i = 1; i <= n; i++) { // O(n)
        for (int k = 1; k * k <= i; k++) {  // O(sqrt(n))
          dp[i] = Math.min(dp[i], dp[i - k*k] + 1);
        }
      }

      return dp[n];
    }
  }
}
