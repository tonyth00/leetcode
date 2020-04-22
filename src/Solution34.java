import shared.Helper;
public class Solution34 {
  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    Helper.print(new Solution().searchRange(nums, 8));  
  }

  static class Solution {
    public int[] searchRange(int[] nums, int target) {
      int[] res = {-1, -1};
      if (nums == null) return res;
      res[0] = search(nums, target, true);
      if (res[0] == -1) return res;
      res[1] = search(nums, target, false);
      return res;
    }

    private int search(int[] nums, int k, boolean first) {
      int L = 0;
      int R = nums.length - 1;
      int res = -1;
      while (L <= R) {
        int M = L + (R - L) / 2;
        if (k == nums[M]) {
          res = M;
          if (first) R = M - 1;
          else L = M + 1;
        } else if (k < nums[M]) {
          R = M - 1;
        } else {
          L = M + 1;
        }
      }
      return res;
    }
  }
}