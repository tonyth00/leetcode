
public class Solution122 {
  public static void main(String[] args) {
    System.out.println(new Solution().maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
  }

  static class Solution {
    public int maxProfit(int[] prices) {
      // greedy
      int profit = 0;
      for (int i = 1; i < prices.length; i++) {
        profit += Math.max(0, prices[i] - prices[i - 1]);
      }  
      return profit;
    }
  }
}