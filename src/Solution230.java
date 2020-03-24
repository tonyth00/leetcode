import shared.Helper;
import shared.TreeNode;

/**
 * Solution230
 */
public class Solution230 {

  public static void main(String[] args) {
    TreeNode root = Helper.generateTree(new Integer[] { 5, 3, 6, 2, 4, null, null, 1 });
    Helper.print(root);
    System.out.println(new Solution().kthSmallest(root, 3));
  }

  static class Solution {
    public int kthSmallest(TreeNode root, int k) {
      int[] res = { k, 0 };
      inorder(root, res);
      return res[1];
    }

    public void inorder(TreeNode node, int[] r) {
      if (node == null) return;

      inorder(node.left, r);
      r[0]--;
      if (r[0] > 0) {
        inorder(node.right, r);
      } else if (r[0] == 0) {
        r[1] = node.val;
      }
    }
  }
}