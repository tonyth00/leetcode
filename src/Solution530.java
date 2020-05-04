import shared.TreeNode;
import shared.Helper;

public class Solution530 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {0, null, 2236, 1277, 2776, 519});
    Helper.print(root);
    System.out.println(new Solution().getMinimumDifference(root));
  }

  static class Solution {
    public int getMinimumDifference(TreeNode root) {
      int[] res = {Integer.MAX_VALUE};
      helper(root, res, null, null);
      return res[0];
    }

    private void helper(TreeNode node, int[] res, Integer min, Integer max) {
      if (node == null) return;

      if (min != null) res[0] = Math.min(res[0], Math.abs(node.val - min));
      if (max != null) res[0] = Math.min(res[0], Math.abs(node.val - max));

      helper(node.left, res, min, node.val);
      helper(node.right, res, node.val, max);
    }
  }
}
