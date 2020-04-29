import shared.TreeNode;
import shared.Helper;
public class Solution617 {
  public static void main(String[] args) {
    TreeNode t1 = Helper.createTree(new Integer[] {1, 3, 2, 5});
    TreeNode t2 = Helper.createTree(new Integer[] {2, 1, 3, null, 4, null, 7});
    Helper.print(new Solution().mergeTrees(t1, t2));
  }

  static class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
      if (t1 == null && t2 == null) return null;
      if (t1 == null) return t2;
      if (t2 == null) return t1;
      TreeNode newNode = new TreeNode(t1.val + t2.val);
      newNode.left = mergeTrees(t1.left, t2.left);
      newNode.right = mergeTrees(t1.right, t2.right);

      return newNode;
    }
  }
}