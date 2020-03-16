/**
 * Solution81
 */
public class Solution81 {

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] { 3, 1, 1 }, 0));
  }

  static class Solution {
    public boolean search(int[] nums, int target) {
      if (nums == null || nums.length == 0)
        return false;

      int L = 0;
      int R = nums.length - 1;

      while (L + 1 < R) {
        int mid = L + (R - L) / 2;
        if (target == nums[mid])
          return true;
        if (nums[mid] > nums[L]) {
          if (nums[L] <= target && target <= nums[mid]) {
            R = mid;
          } else {
            L = mid;
          }
        } else if (nums[mid] < nums[L]) {
          if (nums[mid] <= target && target <= nums[R]) {
            L = mid;
          } else {
            R = mid;
          }
        } else {
          L++;
        }
      }

      if (nums[L] == target || nums[R] == target) return true;
      return false;

    }
  }
}