
import java.util.LinkedList;
import java.util.Queue;

import shared.TreeNode;

/**
 * Solution1302
 */
public class Solution1302 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(7);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(6);
    root.right.right.right = new TreeNode(8);

    System.out.println(new Solution().deepestLeavesSum(root));
  }

  static class Solution {
    public int deepestLeavesSum(TreeNode root) {
      int sum = 0;
      if (root == null)
        return sum;
      Queue<TreeNode> nodes = new LinkedList<>();
      nodes.add(root);

      while (nodes.size() != 0) {
        int size = nodes.size();
        sum = 0;
        for (int i = 0; i < size; i++) {
          TreeNode node = nodes.poll();
          sum += node.val;
          if (node.left != null) {
            nodes.add(node.left);
          }
          if (node.right != null) {
            nodes.add(node.right);
          }
        }
      }
      return sum;
    }
  }
}