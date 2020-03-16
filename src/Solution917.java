/**
 * Solution917
 */
public class Solution917 {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
  }

  static class Solution {
    public String reverseOnlyLetters(String S) {
      if (S == null)
        return S;

      char[] s = S.toCharArray();

      int i = 0;
      int j = S.length() - 1;

      while (i < j) {
        while (i < j && !Character.isLetter(s[i])) i++;
        while (i < j && !Character.isLetter(s[j])) j--;

        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        i++;
        j--;
      }
      return new String(s);
    }
  }
}