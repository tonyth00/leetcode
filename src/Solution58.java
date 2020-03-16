/**
 * Solution58
 */
public class Solution58 {

  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLastWord("HelloWorld"));
  }

  static class Solution {
    public int lengthOfLastWord(String s) {
      return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
  }
}