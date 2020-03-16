import shared.TreeNode;

/**
 * Solution226
 */
public class Solution226 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);

    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

    root.right = new TreeNode(7);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    new Solution().invertTree(root);
  }

  static class Solution {
    public TreeNode invertTree(TreeNode node) {
      if (node == null)
        return node;

      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;
      invertTree(node.left);
      invertTree(node.right);

      return node;
    }
  }
}