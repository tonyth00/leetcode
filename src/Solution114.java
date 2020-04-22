import shared.TreeNode;
import shared.Helper;
public class Solution114 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, 2, null, 3});
    Helper.print(root);
    new Solution().flatten(root);
    Helper.print(root);
  }

  static class Solution {
    public void flatten(TreeNode root) {
      if (root == null) return;
      TreeNode cur = root;

      while (cur != null) {
        if (cur.left != null) {
          TreeNode right = cur.left;
          while (right.right != null) right = right.right;
          right.right = cur.right;
          cur.right = cur.left;
          cur.left = null;
        }

        cur = cur.right;
      }
    }

    public void flatten2(TreeNode root) {
      helper(root);
    }

    private TreeNode helper(TreeNode node) {
      if (node == null) return null;

      TreeNode leftTail = helper(node.left);
      TreeNode rightTail = helper(node.right);

      if (leftTail != null) {
        leftTail.right = node.right;
        node.right = node.left;
        node.left = null;
      }

      return rightTail == null ? leftTail : rightTail;
    }
  }
}