/**
 * Solution96
 */
public class Solution96 {

  public static void main(String[] args) {
    System.out.println(new Solution().numTrees(5));
  }

  static class Solution {
    public int numTrees(int n) {
      int[] G = new int[n + 1];
      G[0] = 1;
      G[1] = 1;

      for (int j = 2; j <= n; j++) {
        for (int i = 1; i <= j; i++) {
          G[j] += G[i - 1] * G[j - i];
        }
      }

      return G[n];

    }
  }
}