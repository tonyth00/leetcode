import shared.TreeNode;
import shared.Helper;
public class Solution110 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {3, 9, 20, null, null, 15, 7});
    System.out.println(new Solution().isBalanced(root));
  }

  static class Solution {
    public boolean isBalanced(TreeNode node) {
      return helper(node) != Integer.MIN_VALUE;
    }

    public int helper(TreeNode node) {
      if (node == null) return -1;
      int left = helper(node.left);
      if (left == -2) return -2;
      int right = helper(node.right);
      if (right == -2) return -2;
      if (Math.abs(left - right) > 1) return -2;
      
      return 1 + Math.max(left, right);
    }


    public boolean isBalanced2(TreeNode node) {
      if (node == null) return true;

      int left = height(node.left);
      int right = height(node.right);
      return Math.abs(left - right) <= 1 && isBalanced2(node.left) && isBalanced2(node.right);

    }

    private int height(TreeNode node) {
      if (node == null) return -1;
      return 1 + Math.max(height(node.left), height(node.right));
    }
  }
}
