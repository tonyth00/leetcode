import shared.Helper;
import shared.TreeNode;

/**
 * Solution124
 */
public class Solution124 {

  public static void main(String[] args) {
    TreeNode root = Helper.generateTree(new Integer[] { -10, 9, 20, null, null, 15, 7 });
    Helper.print(root);
    System.out.println(new Solution().maxPathSum(root));
  }

  static class Solution {
    public int maxPathSum(TreeNode root) {
      int[] max = { Integer.MIN_VALUE };
      helper(root, max);
      return max[0];
    }

    private int helper(TreeNode node, int[] max) {
      if (node == null) return 0;
      int left = Math.max(helper(node.left, max), 0);
      int right = Math.max(helper(node.right, max), 0);

      int sum = node.val + left + right;
      max[0] = Math.max(max[0], sum);

      return node.val + Math.max(left, right);
    }
  }
}