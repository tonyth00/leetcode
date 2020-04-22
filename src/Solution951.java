import shared.TreeNode;
import shared.Helper;

/**
 * Solution951
 */
public class Solution951 {

  public static void main(String[] args) {
    TreeNode root1 = Helper.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, null, null, null, 7, 8 });
    TreeNode root2 = Helper.createTree(new Integer[] { 1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7 });
    Helper.print(root2);
    System.out.println(new Solution().flipEquiv(root1, root2));
  }

  static class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
      if (root1 == null || root2 == null) return root1 == root2;
      if (root1.val != root2.val) return false;
      System.out.println(root1.val + " " + root2.val);
      return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
          || (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
    }
  }
}