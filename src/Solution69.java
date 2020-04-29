
public class Solution69 {
  public static void main(String[] args) {
    System.out.println(new Solution().mySqrt(60));
  }

  static class Solution {
    /**
     * O(log x) time
     * Find the first value for which m*m > x. Answer will be m - 1.
     * For example, if x = 8, m = 3, return 2. if x = 9, m = 4, return 3.
     */
    public int mySqrt(int x) {
      if (x < 2) return x;
      int l = 0;
      int r = x;

      while (l < r) {
        int m = l + (r - l)/2;
        if (m > x/m) r = m;
        else l = m + 1;
      }

      return l - 1;
    }
  }
}