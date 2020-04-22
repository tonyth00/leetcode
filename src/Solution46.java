import java.util.ArrayList;
import java.util.List;

/**
 * Solution46
 */
public class Solution46 {

  public static void main(String[] args) {
    System.out.println(new Solution().permute(new int[] { 1, 2, 3 }));
  }

  static class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      backtrack(nums, res, new ArrayList<>(), new boolean[nums.length]);
      return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] used) {
      if (cur.size() == nums.length) {
        res.add(new ArrayList<>(cur));
      } else {
        for (int i = 0; i < nums.length; i++) {
          if (used[i]) continue;

          used[i] = true;
          cur.add(nums[i]);
          backtrack(nums, res, cur, used);
          cur.remove(cur.size() - 1);
          used[i] = false;
        }
      }
    }
  }
}