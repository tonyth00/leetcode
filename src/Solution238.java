import shared.Helper;

/**
 * Solution238
 */
public class Solution238 {

  public static void main(String[] args) {
    Helper.print(new Solution().productExceptSelf(new int[] { 1, 2, 3, 4 }));
  }

  static class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] res = new int[n];
      int temp = 1;
      for (int i = 0; i < n; i++) {
        res[i] = temp;
        temp *= nums[i];
      }
      temp = 1;
      for (int i = n - 1; i >= 0; i--) {
        res[i] *= temp;
        temp *= nums[i];
      }

      return res;
    }
  }
}