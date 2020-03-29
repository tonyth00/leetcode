import shared.*;
class Solution338 {
  public static void main(String[] args) {
    Helper.print(new Solution().countBits(5));
  }

  static public class Solution {
    public int[] countBits(int num) {
      int[] res = new int[num + 1];
      for (int i = 1; i <= num; i++) {
        res[i] = res[i / 2] + i % 2;
      }
      return res;
    }
  }
}