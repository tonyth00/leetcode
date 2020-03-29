class Solution190 {
  public static void main(String[] args) {
    System.out.println(new Solution().reverseBits(0b00000010100101000001111010011100));
  }

  static class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      int result = 0;
      for (int i = 0; i < 32; i++) {
        result = (result << 1) | (n & 1);
        n = n >> 1;
      }
      return result;
    }
  }
}