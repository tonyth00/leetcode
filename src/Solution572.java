import shared.Helper;
import shared.TreeNode;

/**
 * Solution572
 */
public class Solution572 {

  public static void main(String[] args) {
    TreeNode s = Helper.generateTree(new Integer[] { 3, 4, 5, 1, 2, null, null, null, null, 0 });
    TreeNode t = Helper.generateTree(new Integer[] { 4, 1, 2 });
    System.out.println(new Solution().isSubtree(s, t));
  }

  static class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
      if (s == null) return false;
      if (s.val == t.val && isSameTree(s, t)) return true;
      return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
      if (s == null && t == null) return true;
      if (s == null || t == null) return false;
      return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
  }
}