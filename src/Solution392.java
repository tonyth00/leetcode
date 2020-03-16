/**
 * Solution392
 */
public class Solution392 {

  public static void main(String[] args) {
    System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
  }

  static class Solution {
    public boolean isSubsequence(String s, String t) {
      if (s == null || t == null || s.length() > t.length()) return false;
      if (s.length() == 0) return true;
      int i = 0;

      for (int j = 0; j < t.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          i++;
        }

        if (i == s.length()) return true;
      }

      return false;

    }
  }
}