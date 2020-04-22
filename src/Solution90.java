import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution90
 */
public class Solution90 {

  public static void main(String[] args) {
    System.out.println(new Solution().subsetsWithDup(new int[] { 1, 2, 2 }));
  }

  static class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
      backtrack(nums, res, new ArrayList<>(), 0);
      return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> cur, int start) {
      res.add(new ArrayList<>(cur));

      for (int i = start; i < nums.length; i++) {
        cur.add(nums[i]);
        backtrack(nums, res, cur, i + 1);
        cur.remove(cur.size() - 1);

        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
      }
    }
  }
}