import java.util.ArrayList;
import java.util.List;

/**
 * Solution54
 */
public class Solution54 {

  public static void main(String[] args) {
    System.out.println(new Solution().spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
  }

  static class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return new ArrayList<>();
      int m = matrix.length;
      int n = matrix[0].length;
      List<Integer> list = new ArrayList<>();

      int left = 0;
      int right = n - 1;
      int top = 0;
      int bottom = m - 1;
      while (list.size() < m * n) {
        for (int j = left; j <= right && list.size() < m * n; j++)
          list.add(matrix[top][j]);

        top++;
        for (int i = top; i <= bottom && list.size() < m * n; i++)
          list.add(matrix[i][right]);

        right--;

        for (int j = right; j >= left && list.size() < m * n; j--)
          list.add(matrix[bottom][j]);

        bottom--;

        for (int i = bottom; i >= top && list.size() < m * n; i--)
          list.add(matrix[i][left]);

        left++;
      }

      return list;
    }
  }
}