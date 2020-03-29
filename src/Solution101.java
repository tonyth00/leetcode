import shared.*;

class Solution101 {
  public static void main(String[] args) {
    System.out.println(new Solution().isSymmetric(Helper.generateTree(new Integer[] {1,2,2,3,4,4,3})));
  }

  static class Solution {
    public boolean isSymmetric(TreeNode root) {
      return root == null || helper(root.left, root.right);
    }

    private boolean helper(TreeNode a, TreeNode b) {
      if (a == null && b == null) return true;
      if (a == null || b == null || a.val != b.val) return false;
      return helper(a.left, b.right) && helper(a.right, b.left);
    }
  }
}