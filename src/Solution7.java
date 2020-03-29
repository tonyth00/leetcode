class Solution7 {
  public static void main(String[] args) {
    System.out.println(new Solution().reverse(1234567899));
  }

  static class Solution {
    public int reverse(int x) {
      boolean isNegative = x < 0;
      if (isNegative) x = -x;
      
      int result = 0;
      while (x != 0) {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result) return 0;
        result = newResult;
        x = x / 10;
      }
      if (isNegative) result = -result;

      return result;
    }
  }
}