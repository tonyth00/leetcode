/**
 * Solution482
 */
public class Solution482 {

  public static void main(String[] args) {
    System.out.println(new Solution().licenseKeyFormatting("2-5g-3-J", 2));
  }

  static class Solution {
    public String licenseKeyFormatting(String S, int K) {
      StringBuilder sb = new StringBuilder();
      int i = S.length() - 1;

      int count = 0;
      while (i >= 0) {
        if (S.charAt(i) != '-') {
          if (count != 0 && count % K == 0) {
            sb.append('-');
            count = 0;
          }

          sb.append(Character.toUpperCase(S.charAt(i)));
          count++;
        }
        i--;
      }

      return sb.reverse().toString();
    }
  }
}