import shared.*;

class Solution832 {
  public static void main(String[] args) {
    int[][] A = {
      {1,1,0,0},
      {1,0,0,1},
      {0,1,1,1},
      {1,0,1,0}
    };
    Helper.print(new Solution().flipAndInvertImage(A));
  }

  static class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
      int m = A.length;
      int n = A[0].length;
      for (int i = 0; i < m; i++) {
        for (int j = 0, k = n - 1; j <= k; j++, k--) {
          int temp = A[i][j];
          A[i][j] = A[i][k] ^ 1;
          A[i][k] = temp ^ 1;
        }
      }

      return A;
    }
  }
}