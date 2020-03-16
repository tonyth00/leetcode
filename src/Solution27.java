import shared.Helper;

/**
 * Solution27
 */
public class Solution27 {

  public static void main(String[] args) {
    int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
    int res = new Solution().removeElement(nums, 2);
    System.out.println(res);
    Helper.print(nums);
  }

  static class Solution {
    public int removeElement(int[] nums, int val) {
      int begin = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
          nums[begin] = nums[i];
          begin++;
        }
      }
      return begin;
    }
  }
}