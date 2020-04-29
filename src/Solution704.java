/**
 * Solution704
 */
public class Solution704 {

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] {0, 1, 2, 3, 4, 5, 6 }, 7));
  }

  static class Solution {
    public int search(int[] nums, int target) {
      if (nums.length == 0) return -1;

      int L = 0;
      int R = nums.length;
      while (L < R) {
        int M = L + (R - L)/2;
        if (target == nums[M]) return M;
        else if (target > nums[M]) L = M + 1;
        else R = M;
      }

      return -1;
    }
  }
}