import java.util.Deque;
import java.util.ArrayDeque;
public class Solution32 {
  public static void main(String[] args) {
    System.out.println(new Solution().longestValidParentheses(")()())()()("));
  }

  static class Solution {

    /**
     * Intuition:
     * The top of the stack acts as a "wall". Whenever we get an invalid ')'
     * we move the "wall" to the invalid index, everything to the left is ignored.
     * For a valid ')', we discard its corresponding '(' index, the top is now 
     * the "wall". Everything between the current index i and the wall is valid.
     * Update the max.
     */
    public int longestValidParentheses(String s) {
      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(-1);
      int max = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
          stack.push(i);
        } else {
          stack.pop();
          if (stack.isEmpty()) {
            stack.push(i);
          } else {
            max = Math.max(max, i - stack.peek());
          }
        }
      }
      return max;
    }

    /**
     * Intuition:
     * Everytime we run into an open bracket, store its index onto the stack, as well as the 
     * current state "validFrom". "validFrom" points to the left-most point on the current level.
     */
    public int longestValidParentheses2(String s) {
      int validFrom = Integer.MAX_VALUE;
      int max = 0;
      Deque<Integer> stack = new ArrayDeque<>();
      for (int j = 0; j < s.length(); j++) {
        char c = s.charAt(j);
        if (c == '(') {
          stack.push(validFrom);
          stack.push(j);
          validFrom = Integer.MAX_VALUE;
        } else {
          if (!stack.isEmpty()) {
            int i = stack.pop();
            validFrom = Math.min(i, stack.pop());
            max = Math.max(max, j - validFrom + 1);
          } else {
            validFrom = Integer.MAX_VALUE;
          }
        }
      }
      return max;
    }
  }
}