
public class Solution885 {
  public static void main(String[] args) {
    int[][] result = new Solution().spiralMatrixIII(5, 6, 1, 4);

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }

  }

  static class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
      int[][] result = new int[R * C][2];

      int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
      int dir = 0;
      int count = 0;
      int stepSize = 1;

      result[count] = new int[] { r0, c0 };
      count++;

      while (count < R * C) {
        for (int x = 0; x < 2; x++) {
          for (int i = 0; i < stepSize; i++) {
            r0 += dirs[dir][0];
            c0 += dirs[dir][1];

            if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
              result[count++] = new int[] { r0, c0 };
            }
          }
          dir = (dir + 1) % 4;
        }
        stepSize++;
      }

      return result;
    }
  }
}