/**
 * Solution231
 */
public class Solution231 {

  public static void main(String[] args) {
    System.out.println(new Solution().isPowerOfTwo(16));
  }

  static class Solution {
    public boolean isPowerOfTwo(int n) {
      return n > 0 && (n & (n - 1)) == 0;
    }
  }
}