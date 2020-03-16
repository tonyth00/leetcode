/**
 * Solution63
 */
public class Solution63 {

  public static void main(String[] args) {
    System.out.println(new Solution().uniquePathsWithObstacles(new int[][] { { 1, 0 } }));
  }

  static class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int m = obstacleGrid.length;
      int n = obstacleGrid[0].length;
      int[][] grid = new int[m][n];
      int value = 1;
      for (int i = 0; i < m; i++) {
        if (obstacleGrid[i][0] == 1)
          value = 0;

        grid[i][0] = value;
      }
      value = 1;
      for (int j = 0; j < n; j++) {
        if (obstacleGrid[0][j] == 1)
          value = 0;

        grid[0][j] = value;
      }

      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          grid[i][j] = obstacleGrid[i][j] == 1 ? 0 : grid[i - 1][j] + grid[i][j - 1];
        }
      }

      return grid[m - 1][n - 1];
    }
  }
}