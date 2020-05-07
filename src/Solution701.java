import shared.TreeNode;
import shared.Helper;

public class Solution701 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {4, 2, 7, 1, 3});
    Helper.print(new Solution().insertIntoBST(root, 5));
  }

  static class Solution {
    /**
     * Recursive
     */
    public TreeNode insertIntoBST2(TreeNode node, int val) {
      if (node == null) return new TreeNode(val);
      if (node.val > val) node.left = insertIntoBST(node.left, val);
      else node.right = insertIntoBST(node.right, val);
      return node;
    }

    /**
     * Iterative
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
      TreeNode node = new TreeNode(val);
      if (root == null) return node;
      TreeNode cur = root;
      TreeNode prev = null;
      while (cur != null) {
        prev = cur;
        if (cur.val < val) cur = cur.right;
        else cur = cur.left;
      }
      if (prev.val < val) prev.right = node;
      else prev.left = node;
      return root;
    }
  }
}