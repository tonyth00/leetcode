import java.util.ArrayList;
import java.util.List;

/**
 * Solution78
 */
public class Solution78 {

  public static void main(String[] args) {
    System.out.println(new Solution().subsets(new int[] { 1, 2, 3 }));
  }

  static class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      backtrack(nums, new ArrayList<>(), res, 0);
      return res;
    }

    private void backtrack(int[] nums, List<Integer> cur, List<List<Integer>> res, int start) {
      res.add(new ArrayList<>(cur));
      for (int i = start; i < nums.length; i++) {
        cur.add(nums[i]);
        backtrack(nums, cur, res, i + 1);
        cur.remove(cur.size() - 1);
      }
    }
  }
}