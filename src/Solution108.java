import shared.*;

class Solution108 {
  public static void main(String[] args) {
    Helper.print(new Solution().sortedArrayToBST(new int[] {-10,-3,0,5,9}));
  }

  static class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
      return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int i, int j) {
      if (i > j) return null;

      int mid = i + (j - i) / 2;
      TreeNode node = new TreeNode(nums[mid]);
      node.left = helper(nums, i, mid - 1);
      node.right = helper(nums, mid + 1, j);

      return node;

    }
  }
}