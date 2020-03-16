/**
 * Solution91
 */
public class Solution91 {

  public static void main(String[] args) {
    System.out.println(new Solution().numDecodings("226"));
  }

  static class Solution {
    public int numDecodings(String s) {
      if (s == null || s.length() == 0) return 0;
      int[] dp = new int[s.length() + 1];
      dp[0] = 1;
      dp[1] = s.charAt(0) == '0' ? 0 : 1;
      for (int i = 2; i <= s.length(); i++) {
        int digit = s.charAt(i - 1) - '0';
        if (digit >= 1 && digit <= 9)
          dp[i] += dp[i - 1];

        int prevDigit = s.charAt(i - 2) - '0';
        int a = prevDigit * 10 + digit;
        if (prevDigit != 0 && a >= 1 && a <= 26) {
          dp[i] += dp[i - 2];
        }
      }

      return dp[s.length()];
    }

    // Recursive + memo
    // public int numDecodings(String s) {
    // Map<String, Integer> map = new HashMap<>();
    // int result = numDecodings(s, map);
    // return result;
    // }

    // public int numDecodings(String s, Map<String, Integer> map) {
    // if( map.containsKey(s)) return map.get(s);
    // if (s == null)
    // return 0;
    // if (s.length() == 0)
    // return 1;
    // if (s.charAt(0) == '0') {
    // return 0;
    // }

    // int L = s.length();
    // int sum = 0;

    // if (L >= 2) {
    // int two = Integer.parseInt(s.substring(0, 2));
    // if (two >= 1 && two <= 26) {
    // sum += numDecodings(s.substring(2), map);
    // }
    // }

    // int one = Integer.parseInt(s.substring(0, 1));
    // if (one >= 1 && one <= 9) {
    // sum += numDecodings(s.substring(1), map);
    // }

    // map.put(s, sum);
    // return sum;
    // }
  }
}