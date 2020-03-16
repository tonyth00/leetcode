/**
 * Solution121
 */
public class Solution121 {

  public static void main(String[] args) {
    System.out.println(new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
  }

  static class Solution {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length == 0) return 0;
      int min = Integer.MAX_VALUE;
      int maxProfit = 0;
      for (int i = 0; i < prices.length; i++) {
        min = Math.min(min, prices[i]);
        maxProfit = Math.max(maxProfit, prices[i] - min);
      }
      return maxProfit;
    }
  }
}