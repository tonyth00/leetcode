import java.util.Queue;
import java.util.PriorityQueue;
public class Solution378 {
  public static void main(String[] args) {
    int[][] matrix = {
      { 1,  5,  9},
      {10, 11, 13},
      {12, 13, 15}
    };
    System.out.println(new Solution().kthSmallest(matrix, 8));
  }

  static class Solution {

    /**
     * Intuition:
     * 
     */
    public int kthSmallest(int[][] mat, int k) {
      int n = mat.length; 
      int l = mat[0][0];
      int r = mat[n - 1][n - 1];
      while (l < r) {
        int m = l + (r - l)/2;
        int count = count(mat, m);
        if (count >= k) r = m;
        else l = m + 1;
      }

      return l;
    }

    private int count(int[][] mat, int val) {
      int n = mat.length;
      int i = 0;
      int j = n - 1;
      int count = 0;
      while (i < n && j >= 0) {
        if (val < mat[i][j]) j--;
        else {
          count += (j + 1);
          i++;
        }
      }

      return count;
    }


    /**
     * Intuition:
     * Merge k sorted lists.
     */
    public int kthSmallest2(int[][] matrix, int k) {
      int n = matrix.length;
      Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
      // NlogN
      for (int i = 0; i < n; i++) queue.add(new int[] {matrix[i][0], i, 0});

      // KlogN
      while (k > 0) {
        k--;
        int[] next = queue.remove();
        if (k == 0) return next[0];
        if (next[2] + 1 < n) {
          int i = next[1];
          int j = next[2];
          queue.add(new int[] {matrix[i][j + 1], i, j + 1});
        }
      }

      return 0;
    }
  }
}