import shared.TreeNode;
import shared.Helper;

public class Solution654 {
  public static void main(String[] args) {
    int[] nums = {3, 2, 1, 6, 0, 5};
    Helper.print(new Solution().constructMaximumBinaryTree(nums));
  }

  static class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
      if (l > r) return null;

      int maxIndex = l;
      for (int i = l + 1; i <= r; i++) {
        if (nums[maxIndex] < nums[i]) {
          maxIndex = i;
        }
      }

      TreeNode node = new TreeNode(nums[maxIndex]);
      node.left = helper(nums, l, maxIndex - 1);
      node.right = helper(nums, maxIndex + 1, r);
      return node;

    }
  }
}
