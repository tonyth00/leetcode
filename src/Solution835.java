
public class Solution835 {
  public static void main(String[] args) {
    int[][] A = {
      {1, 1, 0}, 
      {0, 1, 0}, 
      {0, 1, 0}
    };
    int[][] B = {
      {0, 0, 0}, 
      {0, 1, 1}, 
      {0, 0, 1}
    };
    System.out.println(new Solution().largestOverlap(A, B));
  }

  static class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
      int m = A.length;
      int[][] res = new int[3*m - 2][3*m - 2];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
          res[m - 1 + i][m - 1 + j] = A[i][j];
        }
      }
      int max = 0;
      for (int i = 0; i < 2*m - 2; i++) {
        for (int j = 0; j < 2*m - 2; j++) {
          int count = 0;
          for (int k = 0; k < m; k++) {
            for (int l = 0; l < m; l++) {
              if ((B[k][l] & res[i + k][j + l]) > 0) count++;
            }
          }
          max = Math.max(max, count);
        }
      }
      return max;

    }
  }
}
