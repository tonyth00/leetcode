public class Solution518 {
  public static void main(String[] args) {
    int[] coins = {1, 2, 5};
    System.out.println(new Solution().change(5, coins));
  }

  static class Solution {
    /**
     * Intuition:
     * 0/1 Knapsack problem with infinite choices of items. Let amount be weight, let coins be items.
     * Rather than maximizing the value, we just want combinations (not permutations).
     * Guess:
     * dp[i][j] = number of ways to make j using 0 to i coin types.
     * We have two choices:
     * - Use coin i, and see number of ways to make j - coin[i] using 0 to i coin types (We stay on this row because we can use coin i more than once)
     * - Not use coin i, and see number of ways to make j using 0 to i - 1 coin types
     * Add the two together.
     * 
     * To prevent counting duplicates, we only consider one coin at each row. By using the coin, we are appending the coin to the 
     * end of the combination stack:
     * For [1, 2, 5] to make 5
     * 1, 1, 1, 1, 1
     * 1, 1, 1, 2
     * 1, 2, 2
     * 5
     * 
     * Otherwise, we will double count 1, 1, 1, 2 with 2, 1, 1, 1 and 1, 2, 1, 1 and 1, 1, 2, 1
     */
    public int change(int amount, int[] coins) {
      int[] dp = new int[amount + 1];
      dp[0] = 1;
      for (int i = 1; i <= coins.length; i++) {
        for (int j = 0; j <= amount; j++) {
          if (j - coins[i - 1] >= 0) {
            dp[j] += dp[j - coins[i - 1]];
          }
        }
      }
      return dp[amount];
    }

    
    public int change2(int amount, int[] coins) {
      int[][] dp = new int[coins.length + 1][amount + 1];
      dp[0][0] = 1; // one way to make amount 0 with 0 coins
      for (int i = 1; i <= coins.length; i++) {
        for (int j = 0; j <= amount; j++) {
          if (j - coins[i - 1] >= 0) {
            dp[i][j] += dp[i][j - coins[i - 1]]; // spend coin
          }
          dp[i][j] += dp[i - 1][j]; // don't spend coin
        }
      }
      return dp[coins.length][amount];
    }
  }
}
