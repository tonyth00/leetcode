import shared.Helper;
import shared.TreeNode;

/**
 * Solution687
 */
public class Solution687 {

  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] { 1, 4, 5, 4, 4, null, 5 });
    System.out.println(new Solution().longestUnivaluePath(root));
  }

  static class Solution {
    public int longestUnivaluePath(TreeNode node) {
      int[] longest = new int[1];
      helper(node, longest);
      return longest[0];
    }

    public int helper(TreeNode node, int[] longest) {
      if (node == null) return 0;
      int left = helper(node.left, longest);
      int right = helper(node.right, longest);

      left = node.left != null && node.left.val == node.val ? left + 1 : 0;
      right = node.right != null && node.right.val == node.val ? right + 1 : 0;

      longest[0] = Math.max(longest[0], left + right); 
      return Math.max(left, right);

    }
  }
}