/**
 * Solution55
 */
public class Solution55 {

  public static void main(String[] args) {
    System.out.println(new Solution().canJump(new int[] { 3, 2, 1, 0, 4 }));
  }

  static class Solution {
    public boolean canJump(int[] nums) {
      int lastIndex = nums.length - 1;
      for (int i = nums.length - 2; i >= 0; i--) {
        if (i + nums[i] >= lastIndex) {
          lastIndex = i;
        }
      }
      return lastIndex == 0;
    }
  }
}