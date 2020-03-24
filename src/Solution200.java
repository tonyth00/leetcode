class Solution200 {
  public static void main(String[] args) {
    char[][] grid = new char[4][5];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        grid[i][j] = '0';
      }
    }
    grid[0][0] = '1';
    grid[0][1] = '1';
    grid[1][0] = '1';
    grid[1][1] = '1';
    grid[2][2] = '1';
    grid[3][3] = '1';
    grid[3][4] = '1';

    System.out.println(new Solution().numIslands(grid));
  }

  static class Solution {
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

      int numIslands = 0;
      int m = grid.length;
      int n = grid[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '1') {
            dfs(grid, i, j);
            numIslands++;
          }
        }
      }

      return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;

      grid[i][j] = '0';
      for (int[] dir : dirs) {
        dfs(grid, i + dir[0], j + dir[1]);
      }
    }
  }

}