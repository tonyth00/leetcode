public class Solution188 {
  public static void main(String[] args) {
    int[] prices = {6, 1, 3, 2, 4, 7};
    System.out.println(new Solution().maxProfit(2, prices));
  }

  static class Solution {
    /**
     * Intuition:
     * dp[i][j] is the maximum profit we can make, with i transactions, between elements 0 to j
     * At each element, we can choose one of two options:
     * 1) Do nothing, and reap the maximum profit from the previous result: dp[i][j - 1]
     * 2) Sell at j, in which case we must have bought at some point between 0 and j - 1
     * We want to take the maximum of these two scenarios.
     * 
     * If we buy on day x, then the profit we made is prices[j] - prices[x]. We also need to add this 
     * to the maximum profit made at i - 1 transactions on day x:
     * dp[i][j] = max(dp[i][j - 1], prices[j] - prices[x] + dp[i - 1][x]) for x between 0 and j - 1
     * 
     * However, doing this calculation yields O(k*n^2) time, because we are performing O(n) steps for each element in an O(nk) matrix.
     * 
     * We can reduce this complexity by keeping a running maximum of -prices[x] + dp[i - 1][x] as we traverse the row.
     * Then, 
     * runningMax = max(runningMax, -prices[j - 1] + dp[i - 1][j - 1]);
     * dp[i][j] = max(dp[i][j - 1], prices[j] + runningMax);
     * 
     * The above solution now yields O(nk) time.
     * 
     * We can reduce the space complexity from O(nk) to just O(n) by observing that our dp solution only relies on the current row and previous row.
     * Hence it is sufficient to initialize two rows, and alternate between the two.
     * 
     * Edge case:
     * k -> inf
     * In a length n array, we can make at most n - 1 transactions. Given an array of 3 elements, we can buy on day 1, sell day 2, buy day 2, sell day 3.
     * So when k >= n - 1 we can trade as many times as we want, and the solution reduces to Solution122.
     * 
     * 
     */
    public int maxProfit(int k, int[] prices) {
      if (prices == null || prices.length == 0)
        return 0;
      int n = prices.length;

      if (k >= n - 1) return quickSolve(prices);

      int[] even = new int[n];
      int[] odd = new int[n];

      for (int i = 1; i <= k; i++) {
        int[] prev = i % 2 == 1 ? even : odd;
        int[] cur = i % 2 == 1 ? odd : even;
        int max = Integer.MIN_VALUE;
        for (int j = 1; j < n; j++) {
          max = Math.max(max, -prices[j - 1] + prev[j - 1]);
          cur[j] = Math.max(cur[j - 1], prices[j] + max);
        }
      }

      return k % 2 == 1 ? odd[n - 1] : even[n - 1];
    }

    private int quickSolve(int[] prices) {
      int maxProfit = 0;
      for (int i = 1; i < prices.length; i++) {
        maxProfit += Math.max(0, prices[i] - prices[i - 1]);
      }
      return maxProfit;
    } 
  }
}
