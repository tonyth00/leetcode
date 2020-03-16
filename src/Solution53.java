/**
 * Solution53
 */
public class Solution53 {

  public static void main(String[] args) {
    System.out.println(new Solution().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
  }

  static class Solution {
    /**
     * Kadane's algorithm 
     * Scan the given array from left to right. The maximum sum
     * ending at index i, is either itself, or the maximum sum ending at index i - 1
     * plus itself.
     */
    public int maxSubArray(int[] nums) {
      int maxGlobal = nums[0];
      int maxCurrent = nums[0];
      for (int i = 1; i < nums.length; i++) {
        maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
        maxGlobal = Math.max(maxGlobal, maxCurrent);
      }

      return maxGlobal;
    }
  }
}