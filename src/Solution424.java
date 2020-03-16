/**
 * Solution424
 */
public class Solution424 {

  public static void main(String[] args) {
    System.out.println(new Solution().characterReplacement("ABBBA", 2));
  }

  static class Solution {
    public int characterReplacement(String s, int k) {
      int N = s.length();
      int start = 0;
      char[] chars = new char[26];
      int maxCount = 0;
      int max = 0;
      for (int end = 0; end < N; end++) {
        maxCount = Math.max(maxCount, ++chars[s.charAt(end) - 'A']);
        if (end - start + 1 - maxCount > k) { // invalid window
          chars[s.charAt(start) - 'A']--;
          start++;
        } else {
          max = Math.max(max, end - start + 1);
        }
      }
      return max;
    }
  }
}