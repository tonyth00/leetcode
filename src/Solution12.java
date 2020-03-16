public class Solution12 {

  public static void main(String[] args) {
    System.out.println(new Solution().intToRoman(3599));
  }

  static class Solution {
    public String intToRoman(int num) {
      StringBuilder sb = new StringBuilder();

      int thousands = num / 1000;
      num = num % 1000;
      int hundreds = num / 100;
      num = num % 100;
      int tens = num / 10;
      num = num % 10;
      int ones = num;

      while (thousands > 0) {
        sb.append('M');
        thousands--;
      }

      char[][] chars = { { 'M', 'D', 'C' }, { 'C', 'L', 'X' }, { 'X', 'V', 'I' } };
      int[] digits = { hundreds, tens, ones };

      for (int i = 0; i < digits.length; i++) {
        int digit = digits[i];
        char[] g = chars[i];

        if (digit == 9) {
          sb.append("" + g[2] + g[0]);
          digit = 0;
        } else if (digit == 4) {
          sb.append("" + g[2] + g[1]);
          digit = 0;
        } else if (digit >= 5) {
  
          sb.append(g[1]);
          digit -= 5;
        }
        while (digit > 0) {
          sb.append(g[2]);
          digit--;
        }

      }
      return sb.toString();
    }
  }
}