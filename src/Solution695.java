/**
 * Solution695
 */
public class Solution695 {

  public static void main(String[] args) {
    System.out.println(new Solution().maxAreaOfIsland(new int[][] {
      {0,0,1,0,0,0,0,1,0,0,0,0,0},
      {0,0,0,0,0,0,0,1,1,1,0,0,0},
      {0,1,1,0,1,0,0,0,0,0,0,0,0},
      {0,1,0,0,1,1,0,0,1,0,1,0,0},
      {0,1,0,0,1,1,0,0,1,1,1,0,0},
      {0,0,0,0,0,0,0,0,0,0,1,0,0},
      {0,0,0,0,0,0,0,1,1,1,0,0,0},
      {0,0,0,0,0,0,0,1,1,0,0,0,0}
    }));
  }

  static class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

      int m = grid.length;
      int n = grid[0].length;

      int area = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == 1) {
            area = Math.max(area, areaOfIsland(grid, i, j));
          }
        }
      }

      return area;
    }

    public int areaOfIsland(int[][] grid, int i, int j) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
        return 0;
      } else {
        grid[i][j] = 0;
        return 1 + areaOfIsland(grid, i - 1, j) + areaOfIsland(grid, i + 1, j) + areaOfIsland(grid, i, j - 1) + areaOfIsland(grid, i, j + 1);
      }
    }
  }
}