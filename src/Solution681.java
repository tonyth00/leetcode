import java.util.*;
import shared.*;
class Solution681 {
  public static void main(String[] args) {
    System.out.println(new Solution().nextClosestTime("23:59"));
  }

  static class Solution {
    public String nextClosestTime(String time) {
      char[] res = time.toCharArray();
      char[] digits = { res[0], res[1], res[3], res[4]};
      Arrays.sort(digits);

      res[4] = getNext(digits, res[4], '9');
      if (res[4] > time.charAt(4)) return new String(res);      
      res[3] = getNext(digits, res[3], '5');
      if (res[3] > time.charAt(3)) return new String(res);
      res[1] = getNext(digits, res[1], res[0] == '2' ? '3' : '9');
      if (res[1] > time.charAt(1)) return new String(res);
      res[0] = getNext(digits, res[0], '2');
      
      return new String(res);
    }

    private char getNext(char[] digits, char c, char limit) {
      int N = digits.length;
      for (int i = N - 1; i >= 0; i--) {
        if (digits[i] == c) {
          i = (i + 1) % N;
          while (digits[i] > limit) i = (i + 1) % N;
          return digits[i];
        }
      }
      return '0';
    }
  }
}