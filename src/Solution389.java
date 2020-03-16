/**
 * Solution389
 */
public class Solution389 {

  public static void main(String[] args) {
    System.out.println(new Solution().findTheDifference("abcd", "abcde"));
  }

  static class Solution {
    public char findTheDifference(String s, String t) {
      int sum = t.charAt(t.length() - 1);
      for (int i = 0; i < s.length(); i++) {
        sum += t.charAt(i);
        sum -= s.charAt(i);
      }
      
      return (char)sum;
    }
  }
}