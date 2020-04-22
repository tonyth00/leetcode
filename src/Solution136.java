public class Solution136 {
  public static void main(String[] args) {
    System.out.println(new Solution().singleNumber(new int[] { 4, 1, 2, 1, 2 }));
  }

  static class Solution {
    public int singleNumber(int[] nums) {
      int res = 0;
      for (int num : nums) res ^= num;
      return res;
    }
  }
}