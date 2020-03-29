class Solution191 {
  public static void main(String[] args) {
    System.out.println(new Solution().hammingWeight(0b11111111111111111111111111111101));
  }

  static public class Solution {
    // you need to treat n as an unsigned value
    // public int hammingWeight(int n) {
    //   int count = 0;
    //   while (n != 0) {
    //     count += (n & 1);
    //     n = n >>> 1;
    //   }
    //   return count;
    // }
    public int hammingWeight(int n) {
      int count = 0;
      while (n != 0) {
        n &= (n - 1);
        count++;
      }
      return count;
    }
  }
}