import shared.Helper;
import shared.TreeNode;

public class Solution236 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {3,5,1,6,2,0,8,null,null,7,4});
    TreeNode node = new Solution().lowestCommonAncestor(root, root.left, root.left.right.right);
    System.out.println(node.val);
  }

  static class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
      if (node == null) return node;
      if (node == p || node == q) return node;

      TreeNode left = lowestCommonAncestor(node.left, p, q);
      TreeNode right = lowestCommonAncestor(node.right, p, q);

      if (left != null && right != null) return node;

      return left != null ? left : right;
    }
  }
}