import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import shared.Helper;
import shared.TreeNode;

/**
 * Solution199
 */
public class Solution199 {

  public static void main(String[] args) {
    TreeNode root = Helper.generateTree(new Integer[] {1,2,3,null,5,null,4});
    // Helper.print(root);
    System.out.println(new Solution().rightSideView(root));
  }

  static class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      if (root == null) return list;
      
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (queue.size() > 0) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.remove();
          if (node.left != null) queue.add(node.left);
          if (node.right != null) queue.add(node.right);
          if (i == size - 1) list.add(node.val);
        }
      }

      return list;

    }
  }
}