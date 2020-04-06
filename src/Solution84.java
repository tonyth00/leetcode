import java.util.ArrayDeque;
import java.util.Deque;

public class Solution84 {
  public static void main(String[] args) {
    System.out.println(new Solution().largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
  }

  static class Solution {

    // O(n)
    public int largestRectangleArea(int[] heights) {
      int max = 0;
      Deque<Integer> stack = new ArrayDeque<>();
      int i = 0;
      while (i < heights.length) {
        if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
          stack.push(i++);
        else {
          int height = heights[stack.pop()];
          int width = stack.isEmpty() ? i : i - stack.peek() - 1;
          max = Math.max(max, height * width);
        }
      }

      while (!stack.isEmpty()) {
        int height = heights[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        max = Math.max(max, height * width);
      }
      return max;
    }

    // O(n^2)
    public int largestRectangleArea2(int[] heights) {
      int max = 0;
      for (int j = 0; j < heights.length; j++) {
        if (j == heights.length - 1 || heights[j] > heights[j + 1]) {
          int currentMin = Integer.MAX_VALUE;
          for (int i = j; i >= 0; i--) {
            currentMin = Math.min(currentMin, heights[i]);
            max = Math.max(max, (j - i + 1) * currentMin);
            i--;
          }
        }
      }

      return max;
    }
  }
}
