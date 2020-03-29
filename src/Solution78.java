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
      backtrack(nums, 0, new ArrayList<>(), res);
      return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> res) {
      res.add(new ArrayList<>(current));

      for (int i = start; i < nums.length; i++) {
        current.add(nums[i]);
        backtrack(nums, i + 1, current, res);
        current.remove(current.size() - 1);
      }
    }
  }
}