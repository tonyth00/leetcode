import java.util.*;
import shared.TreeNode;
import shared.Helper;

public class Solution1305 {
  public static void main(String[] args) {
    TreeNode root1 = Helper.createTree(new Integer[] {2, 1, 4});
    TreeNode root2 = Helper.createTree(new Integer[] {1, 0, 3});
    System.out.println(new Solution().getAllElements(root1, root2));
  }

  static class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer> res = new ArrayList<>();
      Deque<TreeNode> stack1 = new ArrayDeque<>();
      Deque<TreeNode> stack2 = new ArrayDeque<>();
      populate(stack1, root1);
      populate(stack2, root2);

      while (!stack1.isEmpty() || !stack2.isEmpty()) {
        if (stack2.isEmpty() || !stack1.isEmpty() && stack1.peek().val < stack2.peek().val) {
          TreeNode cur = stack1.pop();
          res.add(cur.val);
          populate(stack1, cur.right);
        } else {
          TreeNode cur = stack2.pop();
          res.add(cur.val);
          populate(stack2, cur.right);
        }
      }
      return res;
    }

    private void populate(Deque<TreeNode> stack, TreeNode root) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
    }
  }
}
