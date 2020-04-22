import java.util.Arrays;

/**
 * Solution322
 */
public class Solution322 {

  public static void main(String[] args) {
    System.out.println(new Solution().coinChange(new int[] { 186, 419, 83, 408 }, 6249));
  }

  static class Solution {

    public int coinChange(int[] coins, int amount) {
      // Arrays.sort(coins);
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;
      for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
          if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
          }
        }
      }

      return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

  }
}