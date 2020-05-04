import shared.Helper;
import shared.TreeNode;

public class Solution538 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {5, 2, 13});
    Helper.print(new Solution().convertBST(root));
  }

  static class Solution {
    public TreeNode convertBST(TreeNode root) {
      dfs(root, new int[] {0});
      return root;
    }

    private void dfs(TreeNode node, int[] sum) {
      if (node == null)
        return;

      dfs(node.right, sum);
      sum[0] += node.val;
      node.val = sum[0];
      dfs(node.left, sum);
    }
  }
}

