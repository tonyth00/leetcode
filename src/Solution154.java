/**
 * Solution154
 */
public class Solution154 {

  public static void main(String[] args) {
    System.out.println(new Solution().findMin(new int[] { 2, 2, 2, 0, 1 }));
  }

  static class Solution {
    public int findMin(int[] nums) {

      int L = 0;
      int R = nums.length - 1;
      if (nums.length == 1 || nums[L] < nums[R])
        return nums[0];

      while (L + 1 < R) {
        int mid = L + (R - L) / 2;

        if (nums[mid] > nums[R]) {
          L = mid + 1;
        } else if (nums[mid] < nums[R]) {
          R = mid;
        } else {
          R--;
        }

      }

      return nums[R];
    }
  }
}