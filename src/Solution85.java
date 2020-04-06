import java.util.Deque;
import java.util.LinkedList;

public class Solution85 {
  public static void main(String[] args) {
    char[][] mat = {
      {'1','0','1','0','0'},
      {'1','0','1','1','1'},
      {'1','1','1','1','1'},
      {'1','0','0','1','0'}
    };
    System.out.println(new Solution().maximalRectangle(mat));
  }

  static class Solution {
    public int maximalRectangle(char[][] mat) {
      if (mat == null || mat.length == 0 || mat[0].length == 0) {
        return 0;
      }

      int m = mat.length;
      int n = mat[0].length;
      int max = 0;
      int[] arr = new int[n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (mat[i][j] == '1') arr[j] += 1;
          else arr[j] = 0;
        }
        max = Math.max(max, maximalRectInHistogram(arr));
      }
      return max;
    }
    private int maximalRectInHistogram(int[] arr) {
      Deque<Integer> stack = new LinkedList<>();
      int i = 0;
      int max = 0;
      while (i < arr.length) {
        if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) stack.push(i++);
        else {
          int height = arr[stack.pop()];
          int width = stack.isEmpty() ? i : i - stack.peek() - 1;
          max = Math.max(max, height * width);
        }
      }

      while (!stack.isEmpty()) {
        int height = arr[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        max = Math.max(max, height * width);
      }
      
      return max;
    }
  }
}