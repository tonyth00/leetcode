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
      Arrays.sort(nums); // we must sort to know when to skip duplicate elements O(nlogn)
      backtrack(nums, new ArrayList<>(), res, 0);
      return res;
    }

    public void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> res, int index) {
      res.add(new ArrayList<>(tempList));

      for (int i = index; i < nums.length; i++) {
        tempList.add(nums[i]);
        backtrack(nums, tempList, res, i + 1);
        tempList.remove(tempList.size() - 1);
        // for [2, 2, 2] we want [2], [2, 2] and [2, 2, 2] so let the DP add to the solution set first.
        // consider skipping duplicates afterwards.

        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
      }
    }
  }
}