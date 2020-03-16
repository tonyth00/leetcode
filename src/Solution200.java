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

    System.out.println(numIslands(grid));
  }

  public static int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int rows = grid.length;
    int cols = grid[0].length;

    int numIslands = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {

        if (grid[i][j] == '1') {
          minimizeRecursive(grid, i, j);
          numIslands++;
        }

      }
    }

    return numIslands;
  }

  public static void minimizeRecursive(char[][] grid, int i, int j) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (i < rows && j < cols && i >= 0 && j >= 0 && grid[i][j] == '1') {
      grid[i][j] = '0';
      minimizeRecursive(grid, i, j + 1);
      minimizeRecursive(grid, i, j - 1);
      minimizeRecursive(grid, i + 1, j);
      minimizeRecursive(grid, i - 1, j);
    }
  }
}