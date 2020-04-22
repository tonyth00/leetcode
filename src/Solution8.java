
public class Solution8 {
  public static void main(String[] args) {
    System.out.println(new Solution().myAtoi("2147483648"));
  }

  static class Solution {
    public int myAtoi(String s) {
      if (s == null || s.length() == 0) return 0;

      int i = 0;
      while (i < s.length() && s.charAt(i) == ' ') i++;
      int sign = 1;
      if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        sign = s.charAt(i) == '-' ? -1 : 1;
        i++;
      }

      int result = 0;
      while (i < s.length()) {
        if (Character.isDigit(s.charAt(i))) {
          int oldResult = result;
          int digit = s.charAt(i) - '0';
          result = result * 10 + sign*digit;
          if (result / 10 != oldResult) {
            return oldResult > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
          }
        } else {
          break;
        }
        i++;
      }
      return result;
    }
  }
}
