/**
 * Solution125
 */
public class Solution125 {

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
  }

  static class Solution {
    public boolean isPalindrome(String s) {
      if (s == null)
        return false;

      for (int i = 0, j = s.length() - 1; i < j;) {
        if (!Character.isLetterOrDigit(s.charAt(i))) {
          i++;
        } else if (!Character.isLetterOrDigit(s.charAt(j))) {
          j--;
        } else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
          i++;
          j--;
        } else {
          return false;
        }
      }

      return true;

    }
  }
}