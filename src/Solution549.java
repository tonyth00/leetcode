import shared.TreeNode;
import shared.Helper;

public class Solution549 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {4, null, 3, 2, 4, 1, null, null, 5});
    System.out.println(new Solution().longestConsecutive(root));
  }

  static class Solution {
    public int longestConsecutive(TreeNode root) {
      int[] max = { 0 };
      helper(root, max);
      return max[0];
    }

    /**
     * Intuition:
     * Solve only the longest consecutive sequence that includes the node, and its children,
     * but not its parent. The parent's calculation is done at the parent node. Recurse children, 
     * once we know information about the child subtrees, process the parent).
     * 
     * - For each child, return the count of the longest increasing/decreasing chain that must
     * include itself. => [incr, decr]
     * - If left is increasing and right is decreasing, we need to sum up the counts
     * Similarly if left is decreasing and right is increasing, we sum up the counts
     * Notice we perform (incr + decr - 1), this is to remove the double counting the 
     * current node.
     * - If both left and right is increasing or decreasing, take the maximum of the two. This 
     * is performed when processing the right subtree.
     */
    private int[] helper(TreeNode node, int[] max) {
      if (node == null) return new int[] {0 , 0};
      int incr = 1, decr = 1;
      if (node.left != null) {
        int[] left = helper(node.left, max);
        if (node.val == node.left.val + 1) decr = 1 + left[1];
        else if (node.val == node.left.val - 1) incr = 1 + left[0];
      }
      if (node.right != null) {
        int[] right = helper(node.right, max);
        if (node.val == node.right.val + 1) decr = Math.max(decr, 1 + right[1]);
        else if (node.val == node.right.val - 1) incr = Math.max(incr, 1 + right[0]);
      }
      max[0] = Math.max(max[0], incr + decr - 1);
      return new int[] {incr, decr};
    }
  }
}
