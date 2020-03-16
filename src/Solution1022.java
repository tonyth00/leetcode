import shared.TreeNode;

/**
 * Solution1022
 */
public class Solution1022 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(1);

    root.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(1);

    System.out.println(new Solution().sumRootToLeaf(root));
  }

  static class Solution {
    public int sumRootToLeaf(TreeNode root) {
      return helper(root, 0);
    }

    public int helper(TreeNode node, int acc) {
      if (node == null) return 0;
      acc = acc*2 + node.val;
      if (node.left == null && node.right == null) return acc;
      return helper(node.left, acc) + helper(node.right, acc);
    }
  }
}