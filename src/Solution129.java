import shared.TreeNode;

public class Solution129 {

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(9);
    root.right = new TreeNode(0);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(1);

    System.out.println(s.sumNumbers(root));
  }

  static class Solution {
    public int sumNumbers(TreeNode root) {
      return sum(root, 0);
    }

    public int sum(TreeNode node, int val) {
      if (node == null) return 0;
      int newVal = val*10 + node.val;
      if (node.left == null && node.right == null) return newVal;
      return sum(node.left, newVal) + sum(node.right, newVal);

    }
  }
}