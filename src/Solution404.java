import shared.TreeNode;

/**
 * Solution404
 */
public class Solution404 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(new Solution().sumOfLeftLeaves(root));
  }

  static class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
      return sumOfLeftLeaves(root, 0);
    }

    public int sumOfLeftLeaves(TreeNode node, int sum) {
      if (node == null) return 0;
      if (isLeaf(node.left)) sum += node.left.val;
      return sum + sumOfLeftLeaves(node.left, 0) + sumOfLeftLeaves(node.right, 0);
    }

    public boolean isLeaf(TreeNode node) {
      return node != null && node.left == null && node.right == null;
    }
  }
}