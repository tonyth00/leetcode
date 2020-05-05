import shared.TreeNode;
import shared.Helper;
import java.util.Deque;
import java.util.ArrayDeque;


public class Solution536 {
  public static void main(String[] args) {
    Helper.print(new Solution().str2tree("-4(2(3)(1))(6()(5))"));
  }

  static class Solution {
    public TreeNode str2tree(String s) {
      Deque<TreeNode> stack = new ArrayDeque<>();
      TreeNode cur = null;
      int sign = 1;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
          int num = c - '0';
          while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
            num = num*10 + s.charAt(i+1) - '0';
            i++;
          }
          num *= sign;
          sign = 1;
          cur = new TreeNode(num);
        } else if (c == '-') {
          sign = -1;
        } else if (c == '(') {
          stack.push(cur);
          cur = null;
        } else if (c == ')') {
          TreeNode child = cur;
          cur = stack.pop();
          if (cur.left != null) cur.right = child;
          else cur.left = child;
        }
      }
      return cur;
    }
  }
}