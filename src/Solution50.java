
public class Solution50 {
  public static void main(String[] args) {
    System.out.println(new Solution().myPow(2.0, -2));
  }

  static class Solution {
    public double myPow(double x, int n) {
      if (n == 0) return 1;
      if (n == Integer.MIN_VALUE) {
        double t = myPow(x, n/2);
        return t*t;
      }
      if (n < 0) return 1 / myPow(x, -n);

      double t = myPow(x, n/2);
      return t*t*(n % 2 == 1 ? x : 1);
    }
  }
}
