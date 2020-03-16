/**
 * Solution377
 */
public class Solution377 {

  public static void main(String[] args) {
    System.out.println(new Solution().combinationSum4(new int[] { 2, 1, 3 }, 35));
  }

  static class Solution {
    public int combinationSum4(int[] nums, int target) {
      int[] targets = new int[target + 1];
      targets[0] = 1;
      for (int i = 1; i <= target; i++) {
        for (int num: nums) {
          if (i >= num) {
            targets[i] += targets[i - num];
          }
        }
      }

      return targets[target];
    }
  }
}