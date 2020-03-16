/**
 * Solution162
 */
public class Solution162 {

  public static void main(String[] args) {
    System.out.println(new Solution().findPeakElement(new int[] { 1, 2, 1, 3, 4, 5, 6 }));
  }

  static class Solution {
    public int findPeakElement(int[] nums) {
      int left = 0;
      int right = nums.length - 1;
      while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < nums[mid + 1]) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }

      return right;
    }
  }
}