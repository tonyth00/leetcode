import shared.Helper;

/**
 * Solution151
 */
public class Solution151 {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseWords("a good   example   "));
  }

  static class Solution {

    /**
     * Not using split
     * 
     */
    public String reverseWords(String s) {
      StringBuilder sb = new StringBuilder();

      int j = s.length() - 1;
      while (j >= 0) {
        if (s.charAt(j) == ' ') j--;
        else {
          int i = j;
          while (i - 1 >= 0 && s.charAt(i - 1) != ' ') i--;
          
          if (sb.length() > 0) sb.append(' ');
          for (int k = i; k <= j; k++) sb.append(s.charAt(k));
          j = i - 1;
        }
      }
      
      return sb.toString();
    }

    /**
     * Using split
     */
    public String reverseWords2(String s) {
      StringBuilder res = new StringBuilder();
      String[] tokens = s.split(" ");
      for (int i = tokens.length - 1; i >= 0; i--) {
        if (tokens[i].length() > 0) {
          if (res.length() > 0) res.append(' ');
          res.append(tokens[i]);
        }
      }
      return res.toString();
    }
  }
}