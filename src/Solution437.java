import shared.TreeNode;
import shared.Helper;
import java.util.Map;
import java.util.HashMap;

public class Solution437 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
    System.out.println(new Solution().pathSum(root, 8));
  }

  static class Solution {

    public int pathSum(TreeNode node, int sum) {
      Map<Integer, Integer> map = new HashMap<>();
      return dfs(node, 0, sum, map);
    }

    private int dfs(TreeNode node, int curSum, int k, Map<Integer, Integer> map) {
      if (node == null) return 0;
      curSum += node.val;
      int count = 0;
      if (curSum == k) count++;
      count += map.getOrDefault(curSum - k, 0);

      map.put(curSum, map.getOrDefault(curSum, 0) + 1);
      count += dfs(node.left, curSum, k, map) + dfs(node.right, curSum, k, map);

      map.put(curSum, map.get(curSum) - 1);
      return count;
    }

    /**
     * Brute force
     * Intuition:
     * - For each node, find a path downwards that includes itself that sums up to "sum"
     * - Do the same for the children.
     * 
     * Time: O(n^2) for an unbalanced tree. For each node, we access all its children, so:
     * T(n) = T(n - 1) + n = O(n^2)
     */
    public int pathSum2(TreeNode node, int sum) {
      if (node == null) return 0;
      return pathSum2(node.left, sum) + pathSum2(node.right, sum) + helper(node, sum);
    }
    
    private int helper(TreeNode node, int remaining) {
      if (node == null) return 0;
      return (remaining == node.val ? 1 : 0) + helper(node.left, remaining - node.val) + helper(node.right, remaining - node.val);
    }
  }
}
