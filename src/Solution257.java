import java.util.ArrayList;
import java.util.List;

import shared.TreeNode;

/**
 * Solution257
 */
public class Solution257 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.right = new TreeNode(5);

    root.right = new TreeNode(3);
    System.out.println(new Solution().binaryTreePaths(root));
  }

  static class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
      List<String> list = new ArrayList<>();

      if (root != null) {
        treeRecursive(root, list, "");
      }
      return list;
    }

    public void treeRecursive(TreeNode node, List<String> list, String path) {
      if (node.left == null && node.right == null)
        list.add(path + node.val);
      if (node.left != null)
        treeRecursive(node.left, list, path + node.val + "->");
      if (node.right != null)
        treeRecursive(node.right, list, path + node.val + "->");
    }
  }
}