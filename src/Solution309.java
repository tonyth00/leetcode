
public class Solution309 {
  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 0, 2};
    System.out.println(new Solution().maxProfit(prices));
  }

  static class Solution {
    /**
     * Intuition: Finite State Machine
     * Consider three states: HOLD, SELL, REST on day j
     * To get to state HOLD, you can continue to hold the stock, or bought stock from REST state
     * To get to state SELL, you must have held stock at HOLD state and sold it at j.
     * To get to REST state, you can continue to REST, or rested as soon as you sold the stock.
     * 
     * Key point:
     * You cannot go from SELL state directly to HOLD state, you must rest at least once.
     * hold[i] = max(hold[i - 1], rest[i - 1] - price)
     * rest[i] = max(rest[i - 1], sold[i - 1])
     * sold[i] = hold[i - 1] + price;
     */
    public int maxProfit(int[] prices) {
      int hold = -Integer.MIN_VALUE;
      int sold = 0;
      int rest = 0;
      for (int price : prices) {
        int prevHold = hold, prevRest = rest, prevSold = sold;
        sold = prevHold + price;
        hold = Math.max(prevHold, prevRest - price);
        rest = Math.max(prevRest, prevSold);
      }

      return Math.max(sold, rest); 
      /**
       * Consider example [1, 3, 4] and [1, 4, 3]:
       * In first case, sold will have max value,
       * In second case, rest will have max value.
       */
    }
  }
}