/**
 * Solution268
 */
public class Solution268 {

  public static void main(String[] args) {
    int[] nums = { 3, 0, 1 };
    System.out.println(new Solution().missingNumber(nums));
  }

  static class Solution {
    public int missingNumber(int[] nums) {
      int res = nums.length;
      for (int i = 0; i < nums.length; i++) {
        res = res ^ i ^ nums[i];
      }
      return res;
    }
    // public int missingNumber(int[] nums) {
    //   int N = nums.length;
    //   int sum = N * (N + 1) / 2;
    //   for (int i = 0; i < nums.length; i++) {
    //     sum -= nums[i];
    //   }
    //   return sum;
    // }
  }
}