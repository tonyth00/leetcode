import java.util.HashMap;
import java.util.Map;

import shared.Helper;
import shared.TreeNode;

/**
 * Solution106
 */
public class Solution106 {

  public static void main(String[] args) {
    int[] postorder = { 9, 15, 7, 20, 3 };
    int[] inorder = { 9, 3, 15, 20, 7 };
    Helper.print(new Solution().buildTree(inorder, postorder));
  }

  static class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
      }
      return helper(inorder, postorder, inorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int postStart, int inStart, int inEnd, Map<Integer, Integer> map) {
      if (inStart > inEnd) return null;

      TreeNode node = new TreeNode(postorder[postStart]);
      int inPivot = map.get(node.val);

      int rightLength = inEnd - inPivot;
      node.right = helper(inorder, postorder, postStart - 1, inPivot + 1, inEnd, map);
      node.left = helper(inorder, postorder, postStart - rightLength - 1, inStart, inPivot - 1, map);

      return node;


    }
  }
}