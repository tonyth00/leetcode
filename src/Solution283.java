import shared.Helper;

/**
 * Solution283
 */
public class Solution283 {

  public static void main(String[] args) {
    int[] nums = { 0, 1, 0, 3, 12 };
    new Solution().moveZeroes(nums);
    Helper.print(nums);
  }

  static class Solution {
    public void moveZeroes(int[] nums) {
      int i = 0;
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] != 0) {
          nums[i++] = nums[j];
        }
      }

      for (; i < nums.length; i++) {
        nums[i] = 0;
      }
    }
  }
}