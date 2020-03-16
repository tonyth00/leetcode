import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import shared.TreeNode;

public class Solution107 {
  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    System.out.println(s.levelOrderBottom(root));
  }

  static class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> list = new LinkedList<>();
      if (root == null)
        return list;

      Queue<TreeNode> nodes = new LinkedList<>();
      nodes.add(root);

      while (!nodes.isEmpty()) {
        List<Integer> newList = new LinkedList<>();
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = nodes.poll();
          newList.add(node.val);
          if (node.left != null) {
            nodes.add(node.left);
          }
          if (node.right != null) {
            nodes.add(node.right);
          }
        }
        list.add(0, newList);
      }

      return list;

    }
  }
}