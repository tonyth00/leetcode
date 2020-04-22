import shared.Helper;
import shared.TreeNode;

/**
 * Solution235
 */
public class Solution235 {

  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
    System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.right).val);
  }

  static class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
      if (p.val < node.val && q.val < node.val) return lowestCommonAncestor(node.left, p, q);
      if (node.val < p.val && node.val < q.val) return lowestCommonAncestor(node.right, p, q);
      return node;
    }
  }
}