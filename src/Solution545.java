import java.util.List;
import java.util.LinkedList;
import shared.TreeNode;
import shared.Helper;

public class Solution545 {
  public static void main(String[] args) {
    TreeNode root =
        Helper.createTree(new Integer[] {1, null, 2, 3, 4});
    Helper.print(root);

    System.out.println(new Solution().boundaryOfBinaryTree(root));
  }

  static class Solution {
    /**
     * Intuition:
     * The problem is best solved by taking away the root from all three recursive calls
     * 
     * Edge case:
     * If root has no left subtree, there's no left boundary
     * If root has no right subtree, there's no right boundary
     * 
     * - Add left boundary to the result so long as it's not a leaf. Terminate at leaf.
     * - Recurse left subtree, adding all the leaf nodes to the result.
     * - Recurse right subtree, adding all the leaf nodes to the result.
     * - Add right boundary to the result so long as it's not a leaf. Add deeper nodes first. Terminate at leaf.
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
      LinkedList<Integer> res = new LinkedList<>();
      if (root == null) return res;
      res.add(root.val);
      leftBounds(root.left, res);
      leaves(root.left, res);
      leaves(root.right, res);
      rightBounds(root.right, res);
      return res;
    }

    private void leftBounds(TreeNode node, List<Integer> res) {
      if (node == null || (node.left == null && node.right == null)) return;
      res.add(node.val);
      if (node.left != null) leftBounds(node.left, res);
      else leftBounds(node.right, res);
    }

    private void rightBounds(TreeNode node, List<Integer> res) {
      if (node == null || (node.left == null && node.right == null)) return;
      if (node.right != null) rightBounds(node.right, res);
      else rightBounds(node.left, res);
      res.add(node.val);
    }

    private void leaves(TreeNode node, List<Integer> res) {
      if (node == null) return;
      if (node.left == null && node.right == null) res.add(node.val);
      leaves(node.left, res);
      leaves(node.right, res);
    }
  }
}
