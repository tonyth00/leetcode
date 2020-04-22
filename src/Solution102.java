import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import shared.Helper;
import shared.TreeNode;

public class Solution102 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
    System.out.println(new Solution().levelOrder(root));
  }

  static class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> list = new LinkedList<>();
      if (root == null)
        return list;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        List<Integer> row = new LinkedList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          row.add(node.val);
          if (node.left != null) queue.add(node.left);
          if (node.right != null) queue.add(node.right);
        }
        list.add(row);
      }
      return list;
    }
  }
}