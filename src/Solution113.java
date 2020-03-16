import java.util.ArrayList;
import java.util.List;

import shared.TreeNode;

/**
 * Solution113
 */
public class Solution113 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(11);
    root.left.left.right = new TreeNode(2);
    root.left.left.left = new TreeNode(7);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);

    System.out.println(new Solution().pathSum(root, 22));
  }

  static class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res = new ArrayList<>();
      helper(root, new ArrayList<>(), sum, res);
      return res;
    }

    public void helper(TreeNode node, List<Integer> path, int remains, List<List<Integer>> res) {
      if (node == null)
        return;

      path.add(node.val);
      remains -= node.val;

      if (node.left == null && node.right == null && remains == 0) { // leaf
        System.out.println("LEAF FOUND " + node.val);
        res.add(new ArrayList<>(path));
      } else {
        helper(node.left, path, remains, res);
        helper(node.right, path, remains, res);
      }
      path.remove(path.size() - 1); //backtrack
    }
  }
}