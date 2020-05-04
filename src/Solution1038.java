import shared.TreeNode;
import shared.Helper;

public class Solution1038 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
    Helper.print(root);
    Helper.print(new Solution().bstToGst(root));
  }

  static class Solution {
    public TreeNode bstToGst(TreeNode root) {
      helper(root, new int[] {0});
      return root;
    }

    private void helper(TreeNode node, int[] sum) {
      if (node == null) return;
      helper(node.right, sum);
      sum[0] += node.val;
      node.val = sum[0];
      helper(node.left, sum);
    }
  }
}
