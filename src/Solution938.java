import shared.TreeNode;

/**
 * Solution938
 */
public class Solution938 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right = new TreeNode(15);
    root.right.right = new TreeNode(18);

    System.out.println(new Solution().rangeSumBST(root, 7, 15));
  }

  static class Solution {
    public int rangeSumBST(TreeNode node, int L, int R) {
      if (node == null) return 0;
      
      int leftSum = node.val < L ? 0 : rangeSumBST(node.left, L, R);
      int rightSum = node.val > R ? 0 : rangeSumBST(node.right, L, R);
      return (node.val >= L && node.val <= R ? node.val : 0) + leftSum + rightSum;
    }
  }
}