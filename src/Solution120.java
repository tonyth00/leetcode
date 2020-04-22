import java.util.*;
public class Solution120 {
  public static void main(String[] args) {
    List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
    System.out.println(new Solution().minimumTotal(triangle));
  }

  static class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
      int n = tri.size();
      int[] res = new int[n];
      for (int i = 0; i < n; i++) res[i] = tri.get(n - 1).get(i);
      for (int i = n - 2; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
          res[j] = tri.get(i).get(j) + Math.min(res[j], res[j + 1]);
        }
      }

      return res[0];
    }
  }
}