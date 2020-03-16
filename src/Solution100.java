import shared.TreeNode;

/**
 * Solution100
 */
public class Solution100 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    System.out.println(new Solution().isSameTree(root, root));
  }

  static class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) return true;
      if (p != null && q != null && p.val == q.val) {
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
      }
      return false;
    }
  }
}