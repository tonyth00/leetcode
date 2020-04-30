
public class Solution415 {
  public static void main(String[] args) {
    System.out.println(new Solution().addStrings("999", "1"));
  }

  static class Solution {
    public String addStrings(String num1, String num2) {
      int i = num1.length() - 1;
      int j = num2.length() - 1;

      int carry = 0;
      StringBuilder sb = new StringBuilder();
      while (i >= 0 || j >= 0 || carry > 0) {
        int sum = carry;
        sum += i >= 0 ? num1.charAt(i--) - '0' : 0;
        sum += j >= 0 ? num2.charAt(j--) - '0' : 0;

        carry = sum / 10;
        sb.append(sum % 10);
      }

      return sb.reverse().toString();
    }
  }
}