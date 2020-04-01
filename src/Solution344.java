import shared.Helper;

/**
 * Solution344
 */
public class Solution344 {

  public static void main(String[] args) {
    char[] s = "hello".toCharArray();
    new Solution().reverseString(s);
    Helper.print(s);
  }

  static class Solution {
    public void reverseString(char[] s) {
      for (int i = 0, j = s.length - 1; i < j; i++, j--) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
      }
    }
  }
}