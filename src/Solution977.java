import shared.Helper;

/**
 * Solution977
 */
public class Solution977 {

  public static void main(String[] args) {
    Helper.print(new Solution().sortedSquares(new int[] { -4, -1, 0, 3, 10 }));
  }

  static class Solution {
    public int[] sortedSquares(int[] A) {
      int[] res = new int[A.length];

      int i = 0;
      int j = A.length - 1;
      int k = A.length - 1;

      while (i <= j) {
        if (Math.abs(A[i]) > Math.abs(A[j])) {
          res[k] = A[i]*A[i];
          i++;
        } else {
          res[k] = A[j]*A[j];
          j--;
        }
        k--;
      }

      return res;
    }
  }
}