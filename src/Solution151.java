import shared.Helper;

/**
 * Solution151
 */
public class Solution151 {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseWords("  hello world!  "));
  }

  static class Solution {
    public String reverseWords(String s) {
      Helper.print(s.split(" "));
      return null;
    }
  }
}