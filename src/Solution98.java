import shared.Helper;
import shared.TreeNode;

/**
 * Solution98
 */
public class Solution98 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(20);

    System.out.println(new Solution().isValidBST(root));
  }

  static class Solution {
    public boolean isValidBST(TreeNode root) {
      return validate(root, null, null);
    }
    
    public boolean validate(TreeNode node, Integer min, Integer max) {
      if (node == null) return true;
      if (min != null && node.val <= min || max != null && node.val >= max) return false;
      return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
  }
}