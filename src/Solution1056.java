
public class Solution1056 {
  public static void main(String[] args) {
    System.out.println(new Solution().confusingNumber(68));
  }

  static class Solution {
    public boolean confusingNumber(int N) {
      int[] map = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
      int n = N;
      int newNum = 0;
      while (n > 0) {
        int digit = n % 10;
        if (map[digit] == -1) return false;
        newNum = newNum * 10 + map[digit];
        n /= 10;
      }
      return newNum != N;
    }
  }
}