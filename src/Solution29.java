
public class Solution29 {
  public static void main(String[] args) {
    System.out.println(new Solution().divide(10, 0));
  }

  static class Solution {
    /**
     * Divisor is assumed > 0

     * Intuition:
     * - Let bExpand = b << x be b multiplied by 2^x, starting at x = 0.
     * - while there is any remainder left to divide.
     * - Expand b until it's larger than a
     * - Backtrack bExpand so that bExpand < a
     * - Subtract bExpand from a
     * - Accumulate multiplier
     * - Account for edge cases
     */
    public int divide(int A, int B) {
      if (A == Integer.MIN_VALUE && B == -1) return Integer.MAX_VALUE;
      if (A == Integer.MIN_VALUE && B == 1) return Integer.MIN_VALUE;
      int a = Math.abs(A);
      int b = Math.abs(B);

      int res = 0;
      while (a - b >= 0) {
        int x = 0;
        while (a - (b << x + 1) >= 0) x++;
        res += 1 << x;
        a -= b << x;
      }

      return (A > 0) == (B > 0) ? res : -res;
    }
  }
}