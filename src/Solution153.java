/**
 * Solution153
 */
public class Solution153 {

  public static void main(String[] args) {
    System.out.println(new Solution().findMin(new int[] { 2, 3, 4, 0, 1 }));
  }

  static class Solution {
    public int findMin(int[] nums) {
      int L = 0;
      int R = nums.length - 1;
      if (nums.length == 0 || nums[L] < nums[R])
        return nums[0];

      while (L + 1 < R) {
        int mid = L + (R - L) / 2;
        if (nums[mid] > nums[L]) {
          L = mid;
        } else if (nums[mid] < nums[L]) {
          R = mid;
        }
      }

      return nums[R];

    }
  }
}