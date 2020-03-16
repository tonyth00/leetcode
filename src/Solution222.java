import shared.Helper;
import shared.TreeNode;

/**
 * Solution222
 */
public class Solution222 {

  public static void main(String[] args) {
    TreeNode root = Helper.generateTree(new Integer[] { 1, 2, 3, 4, 5, 6 });
    System.out.println(new Solution().countNodes(root));
  }

  static class Solution {
    public int countNodes(TreeNode root) {
      if (root == null)
        return 0;

      int height = 0;
      TreeNode node = root;
      while (node != null) {
        height++;
        node = node.left;
      }
      int result = (1 << height) - 1;
      int numMissing = countMissingNodes(root, 1, height);
      return result - numMissing;
    }

    public int countMissingNodes(TreeNode node, int depth, int maxDepth) {
      if (depth == maxDepth) {
        return node == null ? 1 : 0;
      } else {
        int rightCount = countMissingNodes(node.right, depth + 1, maxDepth);
        int leftCount = rightCount > 0 ? countMissingNodes(node.left, depth + 1, maxDepth) : 0;
        return rightCount + leftCount;
      }
    }
  }
}