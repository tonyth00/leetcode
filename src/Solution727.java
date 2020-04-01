/**
 * Solution727
 */
public class Solution727 {

  public static void main(String[] args) {
    System.out.println(new Solution().minWindow("abcdebdde", "bde"));
  }

  static class Solution {
    public String minWindow(String S, String T) {
      char[] t = T.toCharArray();
      int I = 0, J = 0, len = S.length();
      for (int i = 0; i < S.length();) {
        for (char c : t) {
          i = S.indexOf(c, i);
          if (i == -1) return S.substring(I, J);
          i++;
        }
        int end = i--;
        for (int j = t.length - 1; j >= 0; j--) {
          i = S.lastIndexOf(t[j], i);
          i--;
        }
        i++;
        if (len > end - i) {
          I = i;
          J = end;
          len = end - i;
        }
        i++;
      }

      return S.substring(I, J);
    }
  }
}