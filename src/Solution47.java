import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution47
 */
public class Solution47 {

  public static void main(String[] args) {
    System.out.println(new Solution().permuteUnique(new int[] {1, 1, 2}));
  }

  static class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
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

          while (i < nums.length && nums[i] == nums[i + 1]) i++;
        }
      }
    
    }
  }
}
