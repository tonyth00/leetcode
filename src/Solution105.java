import java.util.HashMap;
import java.util.Map;

import shared.Helper;
import shared.TreeNode;

/**
 * Solution105
 */
public class Solution105 {

  public static void main(String[] args) {
    int[] preorder = { 3, 9, 20, 15, 7 };
    int[] inorder = { 9, 3, 15, 20, 7 };
    Helper.print(new Solution().buildTree(preorder, inorder));
  }

  static class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
      }

      return buildTreeHelper(preorder, inorder, 0, 0, preorder.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd,
        Map<Integer, Integer> map) {
      if (inStart > inEnd)
        return null;
      TreeNode root = new TreeNode(preorder[preStart]);

      int inPivot = map.get(root.val);
      int leftTreeSize = inPivot - inStart;
      root.left = buildTreeHelper(preorder, inorder, preStart + 1, inStart, inPivot - 1, map);
      root.right = buildTreeHelper(preorder, inorder, preStart + leftTreeSize + 1, inPivot + 1, inEnd, map);

      return root;
    }
  }
}