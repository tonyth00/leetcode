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
      backtrack(nums, new ArrayList<>(), 0, res);
      return res;
    }

    public void backtrack(int[] nums, List<Integer> tempList, int start, List<List<Integer>> res) {
      res.add(new ArrayList<>(tempList));
      // System.out.println("ADDING " + permutation);
      for (int i = start; i < nums.length; i++) {
        tempList.add(nums[i]);
        backtrack(nums, tempList, i + 1, res);
        tempList.remove(tempList.size() - 1);
      }

    }
  }
}