import shared.Helper;
import shared.TreeNode;

/**
 * Solution98
 */
public class Solution98 {

  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] { 5, 1, 4, null, null, 3, 6 });

    System.out.println(new Solution().isValidBST(root));
  }

  static class Solution {
    public boolean isValidBST(TreeNode root) {
      return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
      if (node == null) return true;
      if (min != null && node.val <= min || max != null && node.val >= max) return false;
      return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    };
  }
}