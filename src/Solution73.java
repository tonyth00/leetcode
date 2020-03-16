import shared.Helper;

/**
 * Solution73
 */
public class Solution73 {

  public static void main(String[] args) {
    int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
    new Solution().setZeroes(matrix);
    Helper.print(matrix);
  }

  static class Solution {
    public void setZeroes(int[][] mat) {
      int m = mat.length;
      int n = mat[0].length;

      boolean firstRow = false;
      boolean firstCol = false;
      if (mat[0][0] == 0) {
        firstRow = true;
        firstCol = true;
      } else {
        for (int j = 1; j < n; j++) {
          if (mat[0][j] == 0) {
            firstRow = true;
            break;
          }
        }
        for (int i = 1; i < m; i++) {
          if (mat[i][0] == 0) {
            firstCol = true;
            break;
          }
        }
      }

      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          if (mat[i][j] == 0) {
            mat[0][j] = 0;
            mat[i][0] = 0;
          }
        }
      }

      for (int i = 1; i < m; i++) {
        if (mat[i][0] == 0) {
          for (int j = 1; j < n; j++) {
            mat[i][j] = 0;
          }
        }
      }
      for (int j = 1; j < n; j++) {
        if (mat[0][j] == 0) {
          for (int i = 1; i < m; i++) {
            mat[i][j] = 0;
          }
        }
      }

      if (firstRow) {
        for (int j = 0; j < n; j++) {
          mat[0][j] = 0;
        }
      }
      if (firstCol) {
        for (int i = 0; i < m; i++) {
          mat[i][0] = 0;
        }
      }

    }
  }
}