public class Solution91 {

  public static void main(String[] args) {
    System.out.println(new Solution().numDecodings("226"));
  }

  static class Solution {
    public int numDecodings(String s) {
      int[] dp = new int[s.length() + 1];
      dp[0] = 1;

      for (int i = 1; i <= s.length(); i++) {
        int ones = s.charAt(i - 1) - '0';
        if (ones != 0) dp[i] += dp[i - 1];

        if (i < 2) continue;
        int twos = s.charAt(i - 2) - '0';
        twos = twos * 10 + ones;
        if (twos >= 10 && twos <= 26) dp[i] += dp[i - 2];
      }

      return dp[s.length()];
    }
  }
}