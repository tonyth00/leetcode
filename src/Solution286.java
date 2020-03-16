import java.util.ArrayDeque;
import java.util.Deque;

import shared.Helper;

/**
 * Solution286
 */
public class Solution286 {

  public static void main(String[] args) {
    int INF = Integer.MAX_VALUE;
    int[][] rooms = new int[][] {{INF, -1, 0, INF}, {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}};
    new Solution().wallsAndGates(rooms);
    Helper.print(rooms);
  }

  static class Solution {
    public void wallsAndGates(int[][] rooms) {
      if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

      int m = rooms.length;
      int n = rooms[0].length;
      Deque<int[]> queue = new ArrayDeque<>();
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (rooms[i][j] == 0) {
            queue.add(new int[] {i, j});
          }
        }
      }

      int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          int[] pos = queue.remove();
          for (int[] dir : dirs) {
            int I = pos[0] + dir[0];
            int J = pos[1] + dir[1];
            if (I >= 0 && I < m && J>= 0 && J < n && rooms[I][J] == Integer.MAX_VALUE) {
              rooms[I][J] = rooms[pos[0]][pos[1]] + 1;
              queue.add(new int[] {I, J});
            }
          }
        }
      }

    }
  }
}