/**
 * Solution213
 */
public class Solution213 {

  public static void main(String[] args) {
    System.out.println(new Solution().rob(new int[] { 1, 2, 3, 1 }));
  }

  static class Solution {
    public int rob(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      if (nums.length == 1) return nums[0];
      return Math.max(robFrom(nums, 0, nums.length - 2), robFrom(nums, 1, nums.length - 1));
    }

    public int robFrom(int[] nums, int start, int end) {
      
      int prev2 = 0;
      int prev1 = nums[start];
      for (int i = start + 1; i <= end; i++) {
        int next = Math.max(prev2 + nums[i], prev1);
        prev2 = prev1;
        prev1 = next;
      }
      return prev1;
    }
  }
}