/**
 * Solution659
 */
public class Solution659 {

  public static void main(String[] args) {
    System.out.println(new Solution().isPossible(new int[] {1,2,3,3,4,4,5,5}));
  }

  static class Solution {
    public boolean isPossible(int[] nums) {
      int prev = Integer.MIN_VALUE;

      int a1 = 0, a2 = 0, a3 = 0;
      int count = 0;
      int cur = 0;
      for (int i = 0; i < nums.length;) {
        cur = nums[i];
        int j = i;
        while (j < nums.length && nums[i] == nums[j]) j++;
        count = j - i;

        if (cur != prev + 1) {
          if (a1 != 0 || a2 != 0) return false;
          a3 = 0; // a1 = 0, a2 = 0
          a1 = count;
        } else {
          int b1 = 0, b2 = 0, b3 = 0;
          if (a1 > count) return false; // number of 1 length sequences require more cur than is available
          b2 += a1; count -= a1; a1 = 0;
          if (a2 > count) return false; // number of 2 length sequences require more cur than is available
          b3 += a2; count -= a2; a2 = 0;
          b3 += Math.min(a3, count); count -= Math.min(a3, count);
          b1 = count;

          a1 = b1; a2 = b2; a3 = b3;
        }
        prev = cur;
        i = j;
      }

      return a1 == 0 && a2 == 0;
    }
  }
}