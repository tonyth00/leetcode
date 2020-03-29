import shared.Helper;
public class Solution66 {
  public static void main(String[] args) {
    Helper.print(new Solution().plusOne(new int[] {8, 9}));
  }

  static class Solution {
    public int[] plusOne(int[] digits) {
      for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] != 9) {
          digits[i]++;
          return digits;
        } else {
          digits[i] = 0;
        }
      }

      int[] ret = new int[digits.length + 1];
      ret[0] = 1;
      return ret;
    }
  }
}