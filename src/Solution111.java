
import java.util.LinkedList;
import java.util.Queue;

import shared.TreeNode;

public class Solution111 {
  public static void main(String[] args) {
    Solution s = new Solution();

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(s.minDepth(root));
  }

  static class Solution {
    public int minDepth(TreeNode root) {
      if (root == null)
        return 0;
  
      Queue<TreeNode> nodes = new LinkedList<TreeNode>();
      int depth = 1;
      nodes.add(root);
      while (!nodes.isEmpty()) {
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = nodes.poll();
          if (node.left == null && node.right == null) {
            return depth;
          }
  
          if (node.left != null)
            nodes.add(node.left);
          if (node.right != null)
            nodes.add(node.right);
        }
        depth++;
      }
  
      return depth;
    }
  }
}

