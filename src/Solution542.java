import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
  public static void main(String[] args) {
    int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
    Solution s = new Solution();
    mat = s.updateMatrix(mat);
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }

  static class Solution {
    public int[][] updateMatrix(int[][] m) {
      Queue<int[]> queue = new LinkedList<int[]>();
      Queue<int[]> newQueue = new LinkedList<int[]>();
      int rows = m.length;
      int cols = m[0].length;
  
      queue.clear();
  
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (m[i][j] == 1) {
            m[i][j] = -1;
          } else if (m[i][j] == 0) {
            queue.add(new int[] { i, j });
          }
        }
      }
  
      int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
  
      while (!queue.isEmpty()) {
        newQueue = new LinkedList<int[]>();
  
        for (int[] e : queue) {
          int i = e[0];
          int j = e[1];
  
          for (int[] d : dirs) {
            int I = i + d[0];
            int J = j + d[1];
            if (I >= 0 && J >= 0 && I < rows && J < cols && m[I][J] == -1) {
              m[I][J] = m[i][j] + 1;
              newQueue.add(new int[] { I, J });
            }
          }
        }
  
        queue = newQueue;
  
      }
  
      return m;
    }
  }
  
}