/**
 * Solution33
 */
public class Solution33 {

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
  }

  static class Solution {
    public int search(int[] nums, int target) {
      if (nums == null || nums.length == 0)
        return -1;

      int L = 0;
      int R = nums.length - 1;

      while (L + 1 < R) {
        int mid = L + (R - L) / 2;
        if (target == nums[mid]) return mid;
        
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
        }
      }

      if (nums[L] == target) return L;
      if (nums[R] == target) return R;

      return -1;

    }
  }
}