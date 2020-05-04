import shared.TreeNode;
import shared.Helper;
public class Solution669 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {3, 0, 4, null, 2, null, null, 1});
    Helper.print(root);
    Helper.print(new Solution().trimBST(root, 1, 3));
  }

  static class Solution {
    public TreeNode trimBST(TreeNode node, int L, int R) {
      if (node == null) return null;
      if (node.val < L) return trimBST(node.right, L, R);
      if (node.val > R) return trimBST(node.left, L, R);
      node.left = trimBST(node.left, L, R);
      node.right = trimBST(node.right, L, R);
      return node;
    }
  }
}