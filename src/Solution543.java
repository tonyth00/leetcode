import shared.Helper;
import shared.TreeNode;

/**
 * Solution543
 */
public class Solution543 {

  public static void main(String[] args) {
    TreeNode root = Helper.generateTree(new Integer[] { 1, 2, 3, 4, 5 });
    Helper.print(root);
    System.out.println(new Solution().diameterOfBinaryTree(root));
  }

  static class Solution {
    public int diameterOfBinaryTree(TreeNode node) {
      int[] diameter = new int[1];
      height(node, diameter);
      return diameter[0];
    }

    public int height(TreeNode node, int[] diameter) {
      if (node == null) return 0;

      int lh = height(node.left, diameter);
      int rh = height(node.right, diameter);

      diameter[0] = Math.max(diameter[0], lh + rh);

      return 1 + Math.max(lh, rh);

    }
  }
}