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
      while (i >= 0 && nums[i] >= nums[i + 1]) i--; // O(n)

      if (i >= 0) {
        int j = nums.length - 1;
        // we must swap with something larger than what is at index i. skip elements equal to itself.
        while (nums[j] <= nums[i]) j--; // O(n)
        swap(nums, i, j);
      }

      reverse(nums, i + 1, nums.length - 1); // O(n)
    }

    public void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
      while (start < end)
        swap(nums, start++, end--);
    }
  }
}