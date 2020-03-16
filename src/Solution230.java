import shared.TreeNode;

/**
 * Solution230
 */
public class Solution230 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.left.right = new TreeNode(2);
    root.right = new TreeNode(4);

    System.out.println(new Solution().kthSmallest(root, 2));
  }

  static class Solution {
    public int kthSmallest(TreeNode root, int k) {
      int[] nums = new int[2];
      inorder(root, k, nums);
      return nums[1];
    }

    public void inorder(TreeNode node, int k, int[] nums) {
      if (node == null)
        return;

      inorder(node.left, k, nums);
      if (++nums[0] == k) {
        nums[1] = node.val;
        return;
      }

      if (nums[0] < k) {
        System.out.println(node.val);
        inorder(node.right, k, nums);
      }

    }
  }
}