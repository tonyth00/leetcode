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
      Arrays.sort(coins);
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, amount + 1);
      dp[0] = 0;
      for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
          if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
          } else {
            break;
          }

        }
      }

      return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

  }
}