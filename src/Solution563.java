import shared.Helper;
import shared.TreeNode;

/**
 * Solution563
 */
public class Solution563 {

  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] { 1, 2, 3, 4, null, 5 });
    Helper.print(root);
    System.out.println(new Solution().findTilt(root));

  }

  static class Solution {
    public int findTilt(TreeNode root) {
      int[] res = new int[1];
      sum(root, res);
      return res[0];
    }

    private int sum(TreeNode node, int[] value) {
      if (node == null) {
        return 0;
      }

      int leftSum = sum(node.left, value);
      int rightSum = sum(node.right, value);

      value[0] += Math.abs(leftSum - rightSum);

      return node.val + leftSum + rightSum;
    }
  }
}