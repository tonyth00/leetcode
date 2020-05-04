import shared.TreeNode;
import shared.Helper;

public class Solution606 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, 2, 3, null, 4});
    System.out.println(new Solution().tree2str(root));
  }

  static class Solution {
    public String tree2str(TreeNode t) {
      StringBuilder sb = new StringBuilder();
      helper(t, sb);
      return sb.toString();
    }

    private void helper(TreeNode node, StringBuilder sb) {
      if (node == null) return;

      sb.append(node.val);
      if (node.left != null || node.right != null) {
        sb.append('(');
        helper(node.left, sb);
        sb.append(')');
      }
      if (node.right != null) {
        sb.append('(');
        helper(node.right, sb);
        sb.append(')');
      }
    }
  }
}
