import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution47
 */
public class Solution47 {

  public static void main(String[] args) {
    System.out.println(new Solution().permuteUnique(new int[] { 1, 1, 2 }));
  }

  static class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      if (nums == null || nums.length == 0) return res;

      Arrays.sort(nums);
      backtrack(nums, new ArrayList<>(), new boolean[nums.length], res);
      return res;
    }

    public void backtrack(int[] nums, List<Integer> permutation, boolean[] visited, List<List<Integer>> res) {
      if (nums.length == permutation.size()) {
        res.add(new ArrayList<>(permutation));
        return;
      }

      for (int i = 0; i < nums.length; i++) {
        if (visited[i]) continue;
        if (i > 0 && nums[i] == nums[i - 1] && !visited[i-1]) continue;
        

        visited[i] = true;
        permutation.add(nums[i]);
        backtrack(nums, permutation, visited, res);
        visited[i] = false;
        permutation.remove(permutation.size() - 1);
        
      }
    }
  }
}