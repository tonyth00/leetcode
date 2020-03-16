
import shared.TreeNode;

public class Solution104 {
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(5);
    System.out.println(s.maxDepth(root));
  }

  static class Solution {
    public int maxDepth(TreeNode node) {
      if (node == null)
        return 0;
      return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
  }
}
