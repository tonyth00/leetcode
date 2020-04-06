/**
 * Solution221
 */
public class Solution221 {

  public static void main(String[] args) {
    // char[][] matrix = {
    //   {'1', '0', '1', '0', '0'},
    //   {'1', '0', '1', '1', '1'},
    //   {'1', '1', '1', '1', '1'},
    //   {'1', '0', '0', '1', '0'},
    // };
    char[][] matrix = {{'0', '1'}};
    System.out.println(new Solution().maximalSquare(matrix));
  }

  static class Solution {
    public int maximalSquare(char[][] mat) {
      if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;

      int m = mat.length;
      int n = mat[0].length;
      int count = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          mat[i][j] -= '0';
          if (mat[i][j] == 1) count = 1;
        }
      }
      for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
          if (mat[i][j] == 1) {
            mat[i][j] = (char)(Math.min(Math.min(mat[i - 1][j], mat[i][j - 1]), mat[i - 1][j - 1]) + 1);
          }
        }
      }
      return count*count;
      
    }

    // brute force
    public int maximalSquare2(char[][] mat) {
      if (mat == null || mat.length == 0 || mat[0].length == 0) return 0;
      int m = mat.length;
      int n = mat[0].length;
      int max = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (mat[i][j] == '1') {
            max = Math.max(max, expand(mat, i, j, 0));
          }
        }
      }

      return max;
    }

    private int expand(char[][] mat, int i, int j, int size) {
      if (i + size >= mat.length || j + size >= mat[0].length) return size * size;
      for (int y = j; y <= j + size; y++) {
        if (mat[i + size][y] != '1') return size * size;
      }
      for (int x = i; x <= i + size; x++) {
        if (mat[x][j + size] != '1') return size * size;
      }

      return expand(mat, i, j, size + 1);
    }
  }
}