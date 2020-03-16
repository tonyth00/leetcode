/**
 * Solution74
 */
public class Solution74 {

  public static void main(String[] args) {
    int[][] mat = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
    
    System.out.println(new Solution().searchMatrix(mat, 3));
  }

  static class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
      if (mat == null || mat.length == 0 || mat[0].length == 0) return false;
      int rows = mat.length;
      int cols = mat[0].length;
      int length = rows * cols;
      int start = 0;
      int end = length - 1;
      // BINARY SEARCH
      while (start <= end) {
        int mid = (start + end) / 2;
        int j = mid % cols;
        int i = mid / cols;

        if (mat[i][j] == target) {
          return true;
        } else if (mat[i][j] > target) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }

      }
      return false;
    }
  }
}