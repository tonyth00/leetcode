import shared.Helper;
import shared.TreeNode;
public class Solution1145 {
  public static void main(String[] args) {
    System.out.println(new Solution().btreeGameWinningMove(Helper.generateTree(new Integer[] {1,2,3,4,5,6,7,8,9,10,11}), 11, 3));
  }

  static class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
      if (n <= 2 || root == null) return false;
      int[] lr = new int[2];
      count(root, lr, x);
      return Math.max(Math.max(lr[0], lr[1]), n - lr[0] - lr[1] - 1) > n / 2;
    }

    private int count(TreeNode node, int[] lr, int x) {
      if (node == null) return 0;
      int left = count(node.left, lr, x);
      int right = count(node.right, lr, x);
      if (node.val == x) {
        lr[0] = left;
        lr[1] = right;
      }
      return 1 + left + right;
    };
  }
}