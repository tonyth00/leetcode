import shared.TreeNode;
import shared.Helper;

public class Solution250 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {7, 82, 82, -79, 98, 98, -79, -79, null, -28,
        -24, -28, -24, null, -79, null, 97, 65, -4, null, 3, -4, 65, 3, null, 97});
    System.out.println(new Solution().countUnivalSubtrees(root));
  }

  static class Solution {
    public int countUnivalSubtrees(TreeNode root) {
      int[] count = {0};
      helper(root, count);
      return count[0];
    }

    private boolean helper(TreeNode node, int[] count) {
      if (node == null) return true;

      boolean left = helper(node.left, count);
      boolean right = helper(node.right, count);
      boolean isUnivalue = left && right && (node.left == null || node.val == node.left.val)
      && (node.right == null || node.val == node.right.val);

      if (isUnivalue) count[0]++;
      return isUnivalue;
    }
  }
}
