import shared.TreeNode;
import shared.Helper;
public class Solution298 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, null, 3, 2, 4, null, null, null, 5});
    Helper.print(root);
    System.out.println(new Solution().longestConsecutive(root));
  }

  static class Solution {
    public int longestConsecutive(TreeNode root) {
      int[] max = { 0 };
      helper(root, max, null, 0);
      return max[0];
    }

    private void helper(TreeNode node, int[] max, TreeNode parent, int count) {
      if (node == null) return;
      if (parent == null || parent.val + 1 == node.val) count++;
      else count = 1;

      max[0] = Math.max(max[0], count);

      helper(node.left, max, node, count);
      helper(node.right, max, node, count);
    }
  }
}
