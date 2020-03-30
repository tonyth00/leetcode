import java.util.Arrays;

/**
 * Solution948
 */
public class Solution948 {

  public static void main(String[] args) {
    System.out.println(new Solution().bagOfTokensScore(new int[] { 33, 4, 28, 24, 96 }, 35));
  }

  static class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
      Arrays.sort(tokens);
      int left = 0;
      int right = tokens.length - 1;
      int maxPoints = 0;
      int points = 0;
      while (left <= right) {
        if (P >= tokens[left]) {
          P -= tokens[left++];
          maxPoints = Math.max(maxPoints, ++points);
        } else if (points > 0) {
          P += tokens[right--];
          points--;
        } else {
          break;
        }
      }

      return maxPoints;
    }
  }
}