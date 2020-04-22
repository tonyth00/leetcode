import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution1197
 */
public class Solution1197 {

  public static void main(String[] args) {
    System.out.println(new Solution().minKnightMoves(0, 300));
  }

  static class Solution {
    final int[][] dirs = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    public int minKnightMoves(int x, int y) {
      x = Math.abs(x);
      y = Math.abs(y);

      Deque<int[]> queue = new ArrayDeque<>(); 
      queue.add(new int[] {0, 0});
      Set<Integer> visited = new HashSet<>();
      int moves = 0;
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          int[] p = queue.remove();
          if (p[0] == x && p[1] == y) return moves;
          for (int[] dir : dirs) {
            int nX = p[0] + dir[0];
            int nY = p[1] + dir[1];
            int key = nX * 1000 + nY;
            if (!visited.contains(key) && nX >= -1 && nY >= -1) {
              queue.add(new int[] {nX, nY});
              visited.add(key);
            }
          }
        }
        moves++;
      }

      return Integer.MAX_VALUE;
    }
  }
}