import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import shared.Helper;
import shared.TreeNode;

class Solution1110 {
  public static void main(String[] args) {
    System.out.println(
        new Solution().delNodes(Helper.createTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }), new int[] { 3, 5 }));
  }

  static class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
      List<TreeNode> res = new ArrayList<>();
      Set<Integer> set = new HashSet<>();
      for (int num : to_delete) set.add(num);
      dfs(root, set, res, false);
      return res;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res, boolean hasParent) {
      if (node == null) return null;
      boolean deleted = set.contains(node.val);
      if (!hasParent && !deleted) res.add(node);

      node.left = dfs(node.left, set, res, !deleted);
      node.right = dfs(node.right, set, res, !deleted);

      return deleted ? null : node;
    }

    public List<TreeNode> delNodesBFS(TreeNode root, int[] to_delete) {
      List<TreeNode> res = new ArrayList<>();
      Set<Integer> set = new HashSet<>();
      for (int num : to_delete)
        set.add(num);

      Map<Integer, Integer> parent = new HashMap<>();
      Deque<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.remove();
          if (!set.contains(node.val)) {
            if (!parent.containsKey(node.val)) res.add(node);
          }

          if (node.left != null) {
            queue.add(node.left);
            if (!set.contains(node.left.val) && !set.contains(node.val)) {
              parent.put(node.left.val, node.val);
            } else {
              node.left = null;
            }
          }

          if (node.right != null) {
            queue.add(node.right);
            if (!set.contains(node.right.val) && !set.contains(node.val)) {
              parent.put(node.right.val, node.val);
            } else {
              node.right = null;
            }
          }
        }
      }

      return res;
    }
  }
}