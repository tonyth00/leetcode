import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import shared.TreeNode;
import shared.Helper;
public class Solution145 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, null, 2, 3});
    System.out.println(new Solution().postorderTraversal(root));
  }

  static class Solution {
    /**
     * Iterative O(n)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
      LinkedList<Integer> res = new LinkedList<>();
      Deque<TreeNode> stack = new ArrayDeque<>();
      if (root == null) return res;
      stack.add(root);

      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        res.addFirst(node.val);
        if (node.left != null) stack.push(node.left);
        if (node.right != null) stack.push(node.right);
      }
      return res;
    }

    /**
     * Trivial recursion
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      dfs(root, res);
      return res;
    }
    private void dfs(TreeNode node, List<Integer> res) {
      if (node == null) return;

      dfs(node.left, res);
      dfs(node.right, res);
      res.add(node.val);
    }
  }
}
