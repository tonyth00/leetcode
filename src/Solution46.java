import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
      List<Integer> list = new ArrayList<>();
      for (int num : nums) list.add(num);
      backtrack(list, res, 0);
      return res;
    }

    private void backtrack(List<Integer> nums, List<List<Integer>> res, int start) {
      if (start == nums.size()) {
        res.add(new ArrayList<>(nums));
      } else {
        for (int i = start; i < nums.size(); i++) {
          Collections.swap(nums, i, start);
          backtrack(nums, res, start + 1);
          Collections.swap(nums, i, start);
        }
      }
    }
  }
}