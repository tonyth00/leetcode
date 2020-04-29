/**
 * Solution35
 */
public class Solution35 {

  public static void main(String[] args) {
    System.out.println(new Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 2));
  }

  static class Solution {
    public int searchInsert(int[] nums, int target) {
      int l = 0;
      int r = nums.length;

      while (l < r) {
        int m = l + (r - l)/2;
        if (nums[m] >= target) {
          r = m;
        } else {
          l = m + 1;
        }
      }

      return l;
    }
  }
}