
public class Solution1351 {
  public static void main(String[] args) {
    int[][] grid = {
      {4,3,2,-1},
      {3,2,1,-1},
      {1,1,-1,-2},
      {-1,-1,-2,-3}
    };
    System.out.println(new Solution().countNegatives(grid));
  }

  static class Solution {
    public int countNegatives(int[][] grid) {
      int sum = 0;
      int m = grid.length;
      int n = grid[0].length;
      int i = m - 1;
      int j = 0;
      while (i >= 0 && j < n) {
        if (grid[i][j] < 0) {
          i--;
          sum += n - j;
        } else {
          j++;
        }
      }

      return sum;
    }
  }
}
