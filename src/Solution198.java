import java.util.HashMap;
import java.util.Map;

/**
 * Solution198
 */
public class Solution198 {

  public static void main(String[] args) {
    System.out.println(new Solution().recursiveRob(new int[] { 2, 7, 9, 3, 1 }));
  }

  static class Solution {


    // iteartive rob, O(1) space, O(n) time
    public int rob(int[] nums) {
      if (nums == null || nums.length == 0)
        return 0;

      int prevPrev = 0;
      int prev = nums[0];
      for (int i = 1; i < nums.length; i++) {
        int next = Math.max(prevPrev + nums[i], prev);
        prevPrev = prev;
        prev = next;
      }

      return prev;
    }
 
    // iterative rob, O(n) space and time
    // public int rob(int[] nums) {
    //   if (nums == null || nums.length == 0)
    //     return 0;
    //   int[] dp = new int[nums.length + 1];
    //   dp[0] = 0;
    //   dp[1] = nums[0];
    //   for (int i = 2; i <= nums.length; i++) {
    //     dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
    //   }

    //   return dp[nums.length];
    // }

    // recursive solution with memo
    public int recursiveRob(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      return rob(nums, nums.length - 1, map);
    }

    public int rob(int[] nums, int i, Map<Integer, Integer> map) {
      if (map.containsKey(i))
        return map.get(i);
      if (i < 0)
        return 0;

      int result = Math.max(nums[i] + rob(nums, i - 2, map), rob(nums, i - 1, map));
      map.put(i, result);
      return result;
    }
  }
}