
public class Solution809 {
  public static void main(String[] args) {
    String S = "heeellooo";
    String[] words = {"hello", "hi", "helo"};
    System.out.println(new Solution().expressiveWords(S, words));
  }

  static class Solution {
    public int expressiveWords(String S, String[] words) {
      int count = 0;
      for (String word : words) {
        if (check(word, S)) count++;
      }
        
      return count;
    }

    private boolean check(String w, String s) {
      int i = 0; int j = 0;
      int i2 = 0; int j2 = 0;
      int m = w.length(), n = s.length();
      while (i < m && j < n) {
        if (w.charAt(i) != s.charAt(j)) return false;
        while (i2 < m && w.charAt(i2) == w.charAt(i)) i2++;
        while (j2 < n && s.charAt(j2) == s.charAt(j)) j2++;
        int wLen = i2 - i;
        int sLen = j2 - j;
        if (sLen < wLen || (sLen == 2 && wLen == 1)) return false;
        i = i2;
        j = j2;
      }

      return i == w.length() && j == s.length();
    }
  }
}
