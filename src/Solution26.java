/**
 * Solution26
 */
public class Solution26 {

  public static void main(String[] args) {
    int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    System.out.println(new Solution().removeDuplicates(nums));
  }

  static class Solution {
    public int removeDuplicates(int[] nums) {
      int i = nums.length > 0 ? 1 : 0;
      for (int num : nums) {
        if (num > nums[i - 1]) {
          nums[i++] = num;
        }
      }
      return i;
    }
  }
}