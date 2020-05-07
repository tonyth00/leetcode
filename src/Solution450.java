import shared.TreeNode;
import shared.Helper;

public class Solution450 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {5, 3, 6, 2, 4, null, 7});
    Helper.print(new Solution().deleteNode(root, 3));
  }

  static class Solution {
    /**
     * Intuition:
     * Go through test cases.
     * 
     * If we've found the key, we delete the key by finding a child as replacement
     * 1.) no children: return null
     * 2.) one child: return that child
     * 3.) two children: find smallest child in right subtree. smallest child has no left child.
     * parent of smallest child takes smallest child's right subtree if available. smallest child's
     * takes root's right and left (thereby replacing it). The only exception is if smallest child is
     * immediately to the right of the root, then we just need to attach root.left to smallest child's left.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) return root;
      if (key < root.val) root.left = deleteNode(root.left, key); // search left subtree
      else if (key > root.val) root.right = deleteNode(root.right, key); // serach right subtree
      else { // value found
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;
        else {
          TreeNode parent = root;
          TreeNode newRoot = root.right;
          while (newRoot.left != null) {
            parent = newRoot;
            newRoot = newRoot.left;
          }

          if (root.right != newRoot) {
            parent.left = newRoot.right;
            newRoot.right = root.right;
          }

          newRoot.left = root.left;
          return newRoot;
        }
      }

      return root;
    }
  }
}
