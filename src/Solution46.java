import java.util.LinkedList;
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
      List<List<Integer>> res = new LinkedList<>();
      if (nums == null || nums.length == 0) return res;

      boolean[] visited = new boolean[nums.length];
      backtrack(nums, new LinkedList<>(), visited, res);
      return res;

    }

    public void backtrack(int[] nums, List<Integer> permutation, boolean[] visited, List<List<Integer>> res) {
      if (nums.length == permutation.size()) {
        res.add(new LinkedList<>(permutation));
      }

      for (int i = 0; i < nums.length; i++) {
        if (visited[i]) continue;

        permutation.add(nums[i]);
        visited[i] = true;
        backtrack(nums, permutation, visited, res);
        visited[i] = false;
        permutation.remove(permutation.size() - 1);
      }
    }
  }
}