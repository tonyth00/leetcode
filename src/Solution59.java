
public class Solution59 {
  public static void main(String[] args) {
    int[][] m = new Solution().generateMatrix(4);

    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        System.out.print(m[i][j] + " ");
      }
      System.out.println();
    }

  }

  static class Solution {
    public int[][] generateMatrix(int n) {
      int[][] mat = new int[n][n];
      int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
      int dir = 0;

      int count = 0;
      int i = 0;
      int j = -1;
      int countdown = 1;
      int N = n;
      while (count < n * n) {
        if (countdown > 0) {
          System.out.println("N " + N);
          for (int x = 0; x < N; x++) {
            i += dirs[dir][0];
            j += dirs[dir][1];

            mat[i][j] = (++count);
          }
          dir = (dir + 1) % 4;
          countdown--;
        } else {
          countdown = 2;
          N--;
        }
      }

      return mat;
    }
  }
}