import java.util.ArrayList;
import java.util.List;

/**
 * Solution39
 */
public class Solution39 {

  public static void main(String[] args) {
    System.out.println(new Solution().combinationSum(new int[] { 2, 3, 6, 7 }, 7));
  }

  static class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<>();
      if (nums == null || nums.length == 0)
        return res;

      backtrack(nums, new ArrayList<>(), target, res, 0);
      return res;
    }

    public void backtrack(int[] nums, List<Integer> permutation, int remaining, List<List<Integer>> res, int start) {
      if (remaining == 0) {
        res.add(new ArrayList<>(permutation));
      } else if (remaining < 0) {
        return;
      } else {
        for (int i = start; i < nums.length; i++) {
          permutation.add(nums[i]);
          backtrack(nums, permutation, remaining - nums[i], res, i);
          permutation.remove(permutation.size() - 1);
        }
      }
    }
  }
}