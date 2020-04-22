
public class Solution240 {
  public static void main(String[] args) {
    int[][] matrix = {
      {1,   4,  7, 11, 15},
      {2,   5,  8, 12, 19},
      {3,   6,  9, 16, 22},
      {10, 13, 14, 17, 24},
      {18, 21, 23, 26, 30}
    };
    System.out.println(new Solution().searchMatrix(matrix, 8));
  }

  static class Solution {
    public boolean searchMatrix(int[][] A, int target) {
      if (A == null || A.length == 0 || A[0].length == 0) return false;
      int m = A.length;
      int n = A[0].length;

      int i = 0;
      int j = n - 1;
      while (i < m && j >= 0) {
        if (target > A[i][j]) i++;
        else if (target < A[i][j]) j--;
        else return true;
      }

      return false;

    }
  }
}