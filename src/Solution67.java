/**
 * Solution67
 */
public class Solution67 {

  public static void main(String[] args) {
    System.out.println(new Solution().addBinary("1010", "1011"));
  }

  static class Solution {
    public String addBinary(String a, String b) {
      int aLen = a.length();
      int bLen = b.length();
      int i = aLen - 1;
      int j = bLen - 1;

      StringBuilder sb = new StringBuilder();
      int carry = 0;
      while (i >= 0 || j >= 0 || carry == 1) {
        int x = i >= 0 ? (a.charAt(i) == '1' ? 1 : 0) : 0;
        int y = j >= 0 ? (b.charAt(j) == '1' ? 1 : 0) : 0;
        int res = x + y + carry;
        carry = 0;
        if (res >= 2) {
          res -=2;
          carry = 1;
        }
        sb.append(res);

        i--;
        j--;
      }

      return sb.reverse().toString();

    }
  }
}