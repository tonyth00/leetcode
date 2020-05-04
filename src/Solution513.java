import shared.TreeNode;
import shared.Helper;
import java.util.Deque;
import java.util.ArrayDeque;
public class Solution513 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, 2, 3, 4, null, 5, 6, null, null, 7});
    System.out.println(new Solution().findBottomLeftValue(root));    
  }

  static class Solution {
    public int findBottomLeftValue(TreeNode root) {
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);

      TreeNode node = null;
      while (!queue.isEmpty()) {
        node = queue.remove();
        if (node.right != null) queue.add(node.right);
        if (node.left != null) queue.add(node.left);
      }

      return node.val;
    }
  }
}