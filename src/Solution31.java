import shared.Helper;

/**
 * Solution31
 */
public class Solution31 {

  public static void main(String[] args) {
    int[] nums = { 2, 3, 1, 3, 3 };
    new Solution().nextPermutation(nums);
    Helper.print(nums);
  }

  static class Solution {
    // solve by case analysis.
    public void nextPermutation(int[] nums) {
      int i = nums.length - 2;
      // find index that breaks descending order
      while (i >= 0 && nums[i] >= nums[i+1]) i--;
      if (i >= 0) { // if not entirely descending
        int j = nums.length - 1;
        while (nums[i] >= nums[j]) j--; // find next number larger than nums[i]
        swap(nums, i, j); // swapping guarantees sequence to right of i is descending
      }
      // reverse descending sequence
      reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
      while (i < j) {
        swap(nums, i++, j--);
      }
    }
  }
}