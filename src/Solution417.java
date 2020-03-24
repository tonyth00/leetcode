import java.util.*;

class Solution417 {
  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2, 2, 3, 5}, 
      {3, 2, 3, 4, 4}, 
      {2, 4, 5, 3, 1}, 
      {6, 7, 1, 4, 5}, 
      {5, 1, 1, 2, 4}
    };
    System.out.println(new Solution().pacificAtlantic(matrix));
  }

  static class Solution {
    final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
      List<List<Integer>> list = new ArrayList<>();
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;

      int m = matrix.length;
      int n = matrix[0].length;
      int[][] pacific = new int[m][n];
      int[][] atlantic = new int[m][n];

      for (int j = 0; j < n; j++) {
        dfs(matrix, 0, j, Integer.MIN_VALUE, pacific);
        dfs(matrix, m - 1, j, Integer.MIN_VALUE, atlantic);
      }

      for (int i = 0; i < m; i++) {
        dfs(matrix, i, 0, Integer.MIN_VALUE, pacific);
        dfs(matrix, i, n - 1, Integer.MIN_VALUE, atlantic);
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
            list.add(Arrays.asList(i, j));
          }
        }
      }

      return list;
    }

    private void dfs(int[][] matrix, int i, int j, int prevHeight, int[][] ocean) {
      if (i < 0 || i >= matrix.length || j < 0 || j>= matrix[0].length || matrix[i][j] < prevHeight || ocean[i][j] == 1) return;

      ocean[i][j] = 1;

      for (int[] dir : dirs) {
        dfs(matrix, i + dir[0], j + dir[1], matrix[i][j], ocean);
      }
    }
  }
}