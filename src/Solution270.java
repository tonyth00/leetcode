import shared.Helper;
import shared.TreeNode;

/**
 * Solution270
 */
public class Solution270 {

  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] { 4, 2, 5, 1, 3 });
    System.out.println(new Solution().closestValue(root, 3.714286));
  }

  static class Solution {
    public int closestValue(TreeNode root, double target) {
      int[] closest = new int[] {root.val};
      helper(root, target, closest);
      return closest[0];
    }

    public void helper(TreeNode node, double target, int[] closest) {
      if (node == null) return;
      if (Math.abs(node.val - target) < Math.abs(closest[0] - target)) {
        closest[0] = node.val;
      }

      if (node.val < target) {
        helper(node.right, target, closest);
      } else {
        helper(node.left, target, closest);
      }
    }
  }
}