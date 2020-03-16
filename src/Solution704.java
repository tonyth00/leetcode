/**
 * Solution704
 */
public class Solution704 {

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
  }

  static class Solution {
    public int search(int[] nums, int target) {
      if (nums.length == 0) return -1;
      int left = 0;
      int right = nums.length - 1;
      while (left + 1 < right) {
        int mid = left + (right - left) / 2;
        if (target == nums[mid])
          return mid;

        if (nums[mid] > nums[left]) {
          if (nums[left] <= target && target <= nums[mid]) {
            right = mid;
          } else {
            left = mid;
          }
        } else if (nums[right] > nums[mid]) {
          if (nums[mid] <= target && target <= nums[right]) {
            left = mid;
          } else {
            right = mid;
          }
        }
      }
      if (nums[left] == target) return left;
      if (nums[right] == target) return right;

      return -1;
    }
  }
}