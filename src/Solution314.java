import java.util.List;
import java.util.ArrayList;
import shared.TreeNode;
import shared.Helper;
import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution314 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5});
    System.out.println(new Solution().verticalOrder(root));
  }

  static class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null)
        return res;
      Map<Integer, List<Integer>> map = new HashMap<>();

      int min = 0;
      int max = 0;

      Deque<TreeNode> queue = new ArrayDeque<>();
      Deque<Integer> colQueue = new ArrayDeque<>();
      queue.add(root);
      colQueue.add(0);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.remove();
          int col = colQueue.remove();
          map.putIfAbsent(col, new ArrayList<>());

          map.get(col).add(node.val);

          if (node.left != null) {
            queue.add(node.left);
            colQueue.add(col - 1);
            min = Math.min(min, col - 1);
          }

          if (node.right != null) {
            queue.add(node.right);
            colQueue.add(col + 1);
            max = Math.max(max, col + 1);
          }
        }
      }

      for (int i = min; i <= max; i++) {
        res.add(map.get(i));
      }
      return res;
    }
  }
}
