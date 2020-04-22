
public class Solution123 {
  public static void main(String[] args) {
    int[] prices = {3, 5, 3, 2, 1, 0};
    System.out.println(new Solution().maxProfit(prices));
  }

  static class Solution {
    /**
     * Intuition:
     * To maximize profit at the end, we want to:
     * minimize the cost of the first buy
     * maximize the profit of first sell
     * minimize the cost of the second buy, taking into account the profit from firstSell
     * maximize the profit of the second sell
     */
    public int maxProfit(int[] prices) {
      int s1 = 0;
      int s2 = Integer.MIN_VALUE;
      int s3 = Integer.MIN_VALUE;
      int s4 = Integer.MIN_VALUE;
      int s5 = Integer.MIN_VALUE;
      for (int price: prices) {
        s2 = Math.max(s2, s1-price);
        s3 = Math.max(s3, s2 + price);
        s4 = Math.max(s4, s3 - price);
        s5 = Math.max(s5, s4 + price);
      }
      return Math.max(s1, Math.max(s3, s5));
    }
  }
}
