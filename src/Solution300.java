/**
 * Solution300
 */
public class Solution300 {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
  }

  static class Solution {
    public int lengthOfLIS(int[] nums) {
      int[] tails = new int[nums.length];
      int length = 0;
      for (int num : nums) {
        int L = 0;
        int R = length - 1;
        while (L <= R) {
          int mid = L + (R - L) / 2;
          if (num > tails[mid]) {
            L = mid + 1;
          } else {
            R = mid - 1;
          }
        }
        tails[L] = num;
        if (L == length) length++;

      }
      return length;
    }
  }
}