import shared.TreeNode;
import shared.Helper;

public class Solution814 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, 1, 0, 1, 1, 0, 1, 0});
    Helper.print(new Solution().pruneTree(root));
  }

  static class Solution {
      public TreeNode pruneTree(TreeNode node) {
        if (node == null) return null;

        node.left = pruneTree(node.left);
        node.right = pruneTree(node.right);

        if (node.left == null && node.right == null && node.val == 0) return null;
        return node;
      }
  }
}
