import java.util.*;
import java.awt.*;
/**
 * Solution403
 */
public class Solution403 {

  public static void main(String[] args) {
    int[] stones = { 0, 1, 2, 4, 7, 11, 15, 16, 21 };
    System.out.println(new Solution().canCross(stones));
  }

  static class Solution {
    public boolean canCross(int[] stones) {
      for (int i = stones.length - 1; i >= 3; i--) {
        if (stones[i] > stones[i - 1] * 2) return false;
      }

      int lastPosition = stones[stones.length - 1];

      HashSet<Integer> set = new HashSet<>();
      for (int i = 0; i < stones.length; i++) set.add(stones[i]);

      Deque<Point> deque = new LinkedList<>();
      deque.add(new Point(0, 0));
      Set<Point> seen = new HashSet<>();

      while (!deque.isEmpty()) {
        Point point = deque.pop();
        if (!seen.add(point)) continue;
        int position = point.x;
        int jumpSize = point.y;
        for (int k = jumpSize - 1; k <= jumpSize + 1; k++) {
          if (k <= 0) continue;
          int nextPosition = position + k;
          if (nextPosition == lastPosition) {
            return true;
          } else if (set.contains(nextPosition)) {
            deque.push(new Point(nextPosition, k));
          }
        }
      }

      return false;
    }
  }
}