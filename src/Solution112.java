import shared.TreeNode;

public class Solution112 {

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);

    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);

    System.out.println(s.hasPathSum(root, 22));
  }

  static class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
      return pathSum(root, sum, 0);
    }

    public boolean pathSum(TreeNode node, int sum, int current) {
      if (node == null) return false;
      if (node.left == null && node.right == null) return current + node.val == sum;
      return pathSum(node.left, sum, current + node.val) || pathSum(node.right, sum, current + node.val);
    }
  }
}