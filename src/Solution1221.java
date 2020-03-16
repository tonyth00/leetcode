/**
 * Solution1221
 */
public class Solution1221 {

  public static void main(String[] args) {
    System.out.println(new Solution().balancedStringSplit("RLRRLLRLRL"));
  }

  static class Solution {
    public int balancedStringSplit(String s) {
      int lCount = 0;
      int rCount = 0;
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'L') {
          lCount++;
        } else {
          rCount++;
        }
        if (lCount > 0 && lCount == rCount) {
          count++;
          lCount = 0;
          rCount = 0;
        }
      }
      return count;
    }
  }
}