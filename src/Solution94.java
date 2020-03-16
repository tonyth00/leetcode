import java.util.LinkedList;
import java.util.List;

import shared.TreeNode;

/**
 * Solution94
 */
public class Solution94 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    System.out.println(new Solution().inorderTraversal(root));
  }

  static class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> list = new LinkedList<>();
      helper(root, list);
      return list;
    }

    public void helper(TreeNode node, List<Integer> list) {
      if (node == null) return;

      helper(node.left, list);
      list.add(node.val);
      helper(node.right, list);

    }
  }
}