import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import shared.TreeNode;
import shared.Helper;

public class Solution103 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {3, 9, 20, null, null, 15, 7});
    System.out.println(new Solution().zigzagLevelOrder(root));
  }

  static class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) return res;
      Deque<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      boolean even = true;
      while (!queue.isEmpty()) {
        int size = queue.size();
        // linked list provides O(1) head/tail insertion.
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.remove();
          if (even) list.addLast(node.val);
          else list.addFirst(node.val);

          if (node.left != null) queue.add(node.left);
          if (node.right != null) queue.add(node.right);
        }
        res.add(list);
        even = !even;
      }

      return res;

    }
  }
}
