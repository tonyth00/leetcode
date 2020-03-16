import java.util.HashSet;

/**
 * Solution202
 */
public class Solution202 {

  public static void main(String[] args) {
    System.out.println(new Solution().isHappy(1));
  }

  static class Solution {
    public boolean isHappy(int n) {
      HashSet<Integer> seen = new HashSet<>();
      
      while (n != 1) {
        int N = n;
        int sum = 0;
        while (N > 0) {
          int digit = N % 10;
          sum += digit*digit;
          N /= 10;
        }
        if (!seen.add(sum)) return false;

        n = sum;
      }

      return true;
    }
  }
}