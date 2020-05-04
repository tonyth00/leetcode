import java.util.List;
import java.util.ArrayList;
import shared.Helper;
import shared.TreeNode;
public class Solution366 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, 2, 3, 4, 5});
    System.out.println(new Solution().findLeaves(root));
  }

  static class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      maxHeight(root, res);

      return res;
    }

    private int maxHeight(TreeNode node, List<List<Integer>> res) {
      if (node == null) return -1;

      int left = maxHeight(node.left, res);
      int right = maxHeight(node.right, res);
      int maxHeight = Math.max(left, right) + 1;
      if (maxHeight == res.size()) res.add(new ArrayList<>());
      res.get(maxHeight).add(node.val);

      return maxHeight;
    }
  }
}