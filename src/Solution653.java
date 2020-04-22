import java.util.HashSet;
import java.util.Set;
import shared.Helper;
import shared.TreeNode;;
public class Solution653 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {5, 3, 6, 2, 4, null, 7});
    System.out.println(new Solution().findTarget(root, 28));
  }

  static class Solution {
    public boolean findTarget(TreeNode root, int k) {
      Set<Integer> set = new HashSet<>();
      return dfs(root, set, k);
    }

    private boolean dfs(TreeNode node, Set<Integer> set, int k) {
      if (node == null) return false;

      if (set.contains(k - node.val)) return true;
      set.add(node.val);
      return dfs(node.left, set, k) || dfs(node.right, set, k);
    };
  }
}