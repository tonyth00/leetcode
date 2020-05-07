import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import shared.TreeNode;
import shared.Helper;
public class Solution515 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, 3, 2, 5, 3, null, 9});
    System.out.println(new Solution().largestValues(root));
  }

  static class Solution {

    /**
     * BFS Solution
     */
    public List<Integer> largestValues(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      if (root == null) return res;
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
          TreeNode cur = queue.remove();
          max = Math.max(max, cur.val);
          if (cur.left != null) queue.add(cur.left);
          if (cur.right != null) queue.add(cur.right);
        }
        res.add(max);
      }
      return res;
    }
    
    /**
     * DFS Solution
     */
    public List<Integer> largestValues2(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      dfs(root, res, 0);
      return res;
    }

    private void dfs(TreeNode node, List<Integer> res, int level) {
      if (node == null) return;

      if (level == res.size()) res.add(node.val);
      else res.set(level, Math.max(res.get(level), node.val));

      dfs(node.left, res, level + 1);
      dfs(node.right, res, level + 1);
    }
  }
}
