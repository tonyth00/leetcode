import shared.Helper;
import shared.TreeNode;

/**
 * Solution222
 */
public class Solution222 {

  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, 2, 3, 4, 5, 6});
    System.out.println(new Solution().countNodes(root));
  }

  static class Solution {
      public int countNodes(TreeNode root) {
        if (root == null)
          return 0;

        int height = 0;
        TreeNode cur = root;
        while (cur.left != null) {
          cur = cur.left;
          height++;
        }

        // how many nodes in bottom layer?
        int L = 0;
        int R = (1 << height) - 1;
        int res = -1;
        while (L <= R) {
          int M = L + (R - L) / 2;
          if (exists(root, M, height)) {
            res = M;
            L = M + 1;
          } else {
            R = M - 1;
          }
        }

        res += 1;

        // num nodes from depth 0 to d - 1 PLUS num nodes in depth d;
        return (1 << height) - 1 + res;
      }

      private boolean exists(TreeNode node, int index, int height) {
        int L = 0;
        int R = (1 << height) - 1;
        for (int i = 0; i < height; i++) {
          int M = L + (R - L) / 2;
          if (index > M) {
            node = node.right;
            L = M + 1;
          } else {
            node = node.left;
            R = M;
          }
        }
        return node != null;
      }
  }
}
