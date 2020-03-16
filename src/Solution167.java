/**
 * Solution167
 */
public class Solution167 {

  public static void main(String[] args) {
    int[] nums = { 2, 7, 11, 15 };
    int target = 9;
    int[] result = new Solution().twoSum(nums, target);

    System.out.println(result[0] + " " + result[1]);
  }

  static class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] result = { 0, 0 };

      int low = 0;
      int high = nums.length - 1;

      while (low < high) {
        if (nums[low] + nums[high] == target) {
          result[0] = low + 1;
          result[1] = high + 1;
          break;
        } else if (nums[low] + nums[high] > target) {
          high--;
        } else {
          low++;
        }
      }

      return result;
    }
  }
}