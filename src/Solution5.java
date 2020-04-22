/**
 * Solution5
 */
public class Solution5 {

  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("babad"));
  }

  static class Solution {
    public String longestPalindrome(String s) {
      int[] res = {0, -1};
      char[] ch = s.toCharArray();
      for (int i = 0; i < ch.length; i++) {
        expandAround(ch, i, i, res);
        expandAround(ch, i, i + 1, res);
      }

      return s.substring(res[0], res[1] + 1);
    }

    private void expandAround(char[] ch, int i, int j, int[] res) {
      while (i >= 0 && j < ch.length && ch[i]==ch[j]) {
        i--;
        j++;
      }
      i++; j--;
      if (res[1] - res[0] < j - i) {
        res[1] = j;
        res[0] = i;
      }
    }
  }
}