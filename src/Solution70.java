import java.util.HashMap;
import java.util.Map;

/**
 * Solution70
 */
public class Solution70 {

  public static void main(String[] args) {
    System.out.println(new Solution().climbStairs(5));
  }

  static class Solution {

    public int climbStairs(int n) {
      if (n < 0)
        return -1;
      Map<Integer, Integer> map = new HashMap<>();
      map.put(0, 0);
      map.put(1, 1);
      map.put(2, 2);
      return helper(n, map);
    }

    public int helper(int n, Map<Integer, Integer> map) {
      if (map.containsKey(n)) {
        return map.get(n);
      } else {
        int result = helper(n - 1, map) + helper(n - 2, map);
        map.put(n, result);
        return result;
      }
    }
  }
}