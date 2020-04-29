import shared.Helper;
import java.util.Queue;
import java.util.PriorityQueue;
public class Solution1337 {
  public static void main(String[] args) {
    int[][] mat = {
      {1,1,1,1,1},
      {1,0,0,0,0},
      {1,1,0,0,0},
      {1,1,1,1,0},
      {1,1,1,1,1}
      
    };
    Helper.print(new Solution().kWeakestRows(mat, 3));
  }

  static class Solution {
    /**
     * Complexity:
     * O(mlog(nk))
     */
    public int[] kWeakestRows(int[][] mat, int k) {
      // MAX heap.
      Queue<int[]> queue = new PriorityQueue<>((a, b) -> {
        if (a[0] == b[0]) return Integer.compare(b[1], a[1]); // if strengths are same, higher index priority
        return Integer.compare(b[0], a[0]); // higher strength priority
      });
      int m = mat.length;

      // m*(logn + logk) = mlog(nk) 
      for (int i = 0; i < m; i++) { //m
        int strength = search(mat[i]); // log(n)
        queue.add(new int[] {strength, i}); //log(k)
        if (queue.size() > k) queue.poll();
      }
      int[] res = new int[k];
      for (int i = k - 1; i >= 0; i--) {
        res[i] = queue.remove()[1]; //k log(k)
      }
      return res;
    }

    /**
     * Search first index = 0
     */
    private int search(int[] nums) {
      int L = 0;
      int R = nums.length;
      while (L < R) {
        int M = L + (R - L)/2;
        if (nums[M] == 0) R = M;
        else L = M + 1; 
      }
      return L;
    }

    /**
     * Vertically iterate the matrix. If mat[i][j] = 0 and mat[i][j - 1] = 1
     * we have the next weakest strength row.
     * 
     */
    public int[] kWeakestRows2(int[][] mat, int k) {
      int[] res = new int[k];
      int s = 0;
      int m = mat.length;
      int n = mat[0].length;
      for (int j = 0; j <= n; j++) {
        for (int i = 0; i < m; i++) {
          if (j == n || mat[i][j] == 0) {
            if (j == 0 || mat[i][j - 1] == 1) res[s++] = i;
          }
          if (s == k) return res;
        }
      }
      return res;
    }
  }
}