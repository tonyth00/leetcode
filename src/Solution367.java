
public class Solution367 {
  public static void main(String[] args) {
    System.out.println(new Solution().isPerfectSquare(16));
  }
  static class Solution {
    public boolean isPerfectSquare(int num) {
      if (num < 2) return true;

      int l = 0;
      int r = num;
      while (l < r) {
        int m = l + (r - l)/2;
        if (m > num / m) r = m;
        else l = m + 1;
      }

      return (l - 1) * (l - 1) == num;
    }
  }
}