import shared.Helper;

public class Solution48 {

  public static void main(String[] args) {
    int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    new Solution().rotate(mat);
    Helper.print(mat);
  }

  static class Solution {
    public void rotate(int[][] mat) {
      int m = mat.length;
      int n = mat[0].length;
      // rotate about y-axis
      for (int i = 0; i < m / 2; i++) {
        int[] temp = mat[i];
        mat[i] = mat[m - 1 - i];
        mat[m - 1 - i] = temp;
      }

      for (int i = 0; i < m; i++) {
        for (int j = i + 1; j < n; j++) {
          int temp = mat[i][j];
          mat[i][j] = mat[j][i];
          mat[j][i] = temp;
        }
      }
    }
  }
}