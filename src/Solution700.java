import shared.TreeNode;
import shared.Helper;
public class Solution700 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {4, 2, 7, 1, 3});
    Helper.print(new Solution().searchBST(root, 5));
  }

  static class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
      TreeNode cur = root;
      while (cur != null) {
        if (cur.val == val) break;
        else if (cur.val < val) cur = cur.right;
        else cur = cur.left;
      }

      return cur;
    }
  }
}