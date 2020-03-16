public class Solution463 {

  public static void main(String[] args) {
    int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
    System.out.println(new Solution().islandPerimeter(grid));
  }

  static class Solution {
    public int islandPerimeter(int[][] m) {
      if (m == null || m.length == 0 || m[0].length == 0)
        return 0;

      int rows = m.length;
      int cols = m[0].length;

      int i = 0, j = 0;
      boolean found = false;
      for (i = 0; i < rows; i++) {
        for (j = 0; j < cols; j++) {
          if (m[i][j] == 1) {
            found = true;
            break;
          }
        }
        if (found)
          break;
      }

      int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
      return helper(m, i, j, dirs);

    }

    public int helper(int[][] m, int i, int j, int[][] dirs) {
      // already = 1
      m[i][j] = -1;
      int count = 0;
      for (int[] dir : dirs) {
        int x = j + dir[1];
        int y = i + dir[0];
        if (x < 0 || x >= m[0].length || y < 0 || y >= m.length || m[y][x] == 0) {
          count++;
        } else if (m[y][x] == 1) {
          count += helper(m, y, x, dirs);
        }
      }
      return count;
    }
  }

}