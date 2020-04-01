import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution946
 */
public class Solution946 {

  public static void main(String[] args) {
    System.out.println(new Solution().validateStackSequences(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5, 3, 2, 1}));
  }
  
  static class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
      int j = 0;
      int n = pushed.length;
      Deque<Integer> stack = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        stack.push(pushed[i]);
        while (!stack.isEmpty() && stack.peek() == popped[j]) {
          stack.pop();
          j++;
        }
      }
      return stack.isEmpty();
    }
  }
}