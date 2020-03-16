/**
 * Solution152
 */
public class Solution152 {

  public static void main(String[] args) {
    System.out.println(new Solution().maxProduct(new int[] { 2, 3, -2, 4 }));
  }

  static class Solution {
    public int maxProduct(int[] nums) {
      int r = nums[0];
      for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
        if (nums[i] < 0) {
          int temp = imax;
          imax = imin;
          imin = temp;
        }

        imax = Math.max(imax*nums[i], nums[i]);
        imin = Math.min(imin*nums[i], nums[i]);
        r = Math.max(imax, r);
      }
      return r;
    }
  }
}