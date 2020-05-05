import java.util.*;
import shared.TreeNode;
import shared.Helper;

public class Solution652 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, 2, 3, 4, null, 2, 4, null, null, 4});
    System.out.println(new Solution().findDuplicateSubtrees(root));
  }

  static class Solution {

    /**
     * Brute force solution
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
      Map<String, Integer> map = new HashMap<>();
      List<TreeNode> res = new ArrayList<>();
      helper(root, map, res);
      return res;
    }

    private String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
      if (node == null) return "#";
      String serial = node.val + "," + helper(node.left, map, res) + "," + helper(node.right, map, res);
      map.put(serial, map.getOrDefault(serial, 0) + 1);
      if (map.get(serial) == 2) res.add(node);
      return serial;
    }
  }
}
