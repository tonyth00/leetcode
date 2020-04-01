import shared.Helper;
import shared.TreeNode;

public class Solution337 {
  public static void main(String[] args) {
    System.out
        .println(new Solution().rob(Helper.generateTree(new Integer[] {3, 4, 5, 1, 3, null, 1})));
  }

  static class Solution {
    public int rob(TreeNode root) {
      int[] res = dfs(root);
      return Math.max(res[0], res[1]);
    }

    /**
     * 
     * @param node
     * @return res[0] is max that can be robbed including the node,
     *         res[1] is the max that can be robbed excluding the node
     */
    private int[] dfs(TreeNode node) {
      if (node == null)
        return new int[2];

      int[] left = dfs(node.left);
      int[] right = dfs(node.right);

      return new int[] {node.val + left[1] + right[1],
          Math.max(left[0], right[0]) + Math.max(right[0], right[1])};

    }
  }
}
