import java.util.HashSet;
import java.util.Stack;

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

      Stack<Integer> positions = new Stack<>();
      Stack<Integer> jumpSizes = new Stack<>();
      positions.push(0);
      jumpSizes.push(0);
      
      while (!positions.isEmpty()) {
        int position = positions.pop();
        int jumpSize = jumpSizes.pop();

        for (int k = jumpSize - 1; k <= jumpSize + 1; k++) {
          if (k <= 0) continue;
          int nextPosition = position + k;
          // System.out.println("nextpos " + nextPosition);
          if (nextPosition == lastPosition) {
            return true;
          } else if (set.contains(nextPosition)) {
            positions.push(nextPosition);
            jumpSizes.push(k);
          }
        }
      }

      return false;
    }
  }
}