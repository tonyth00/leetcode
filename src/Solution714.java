
public class Solution714 {
  public static void main(String[] args) {
    int[] prices = {1, 3, 2, 8, 4, 9};
    int fee = 2;
    System.out.println(new Solution().maxProfit(prices, fee));
  }

  static class Solution {
    public int maxProfit(int[] prices, int fee) {
      int sell = 0;
      int buy = prices[0];
      for (int price: prices) {
        int prevBuy = buy, prevSell = sell;
        buy = Math.max(prevBuy, prevSell - price);
        sell = Math.max(prevSell, prevBuy + price - fee);
      }

      return sell;
    }
  }
}