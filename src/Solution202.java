import java.util.*;

/**
 * Solution202
 */
public class Solution202 {

  public static void main(String[] args) {
    System.out.println(new Solution().isHappy(20));
  }

  static class Solution {
    public boolean isHappy(int n) {
      Set<Integer> seen = new HashSet<>();
      seen.add(n);
      while(n != 1) {
        int sum = 0;
        
        while (n > 0) {
          int a = n % 10;
          n /= 10;
          sum += a*a;
        }
        if (!seen.add(sum)) return false;

        n = sum;
      }

      return true;
    }
  }
}