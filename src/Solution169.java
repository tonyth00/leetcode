/**
 * Solution169
 */
public class Solution169 {

  public static void main(String[] args) {
    System.out.println(new Solution().majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
  }

  static class Solution {
    public int majorityElement(int[] nums) {
      int candidate = -1;
      int count = 0;
      for (int num : nums) {
        if (count == 0) {
          count++;
          candidate = num;
        } else if (num == candidate) {
          count++;
        } else {
          count--;
        }
      }
      return candidate;
    }
  }
}