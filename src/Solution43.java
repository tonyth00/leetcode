public class Solution43 {
  public static void main(String[] args) {
    System.out.println(new Solution().multiply("123", "987"));
  }

  static class Solution {
    public String multiply(String num1, String num2) {
      int m = num1.length();
      int n = num2.length();
      int[] res = new int[m + n];

      for (int j = n - 1; j >= 0; j--) {
        for (int i = m - 1; i >= 0; i--) {
          int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
          res[i + j + 1] += num;
          res[i + j] += res[i + j + 1] / 10;
          res[i + j + 1] %= 10;
        }
      }

      StringBuilder sb = new StringBuilder();
      boolean start = false;
      for (int num : res) {
        if (num != 0) start = true;
        if (start) sb.append(num);
      };

      return sb.length() == 0 ? "0" : sb.toString();
      
    }
  }
}
