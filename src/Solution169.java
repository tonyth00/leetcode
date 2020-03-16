/**
 * Solution169
 */
public class Solution169 {

  public static void main(String[] args) {
    System.out.println(new Solution().majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
  }

  static class Solution {
    public int majorityElement(int[] nums) {
      int candidate = nums[0];
      int count = 1;
      for (int i = 1; i < nums.length; i++) {
        if (count == 0) {
          count++;
          candidate = nums[i];
        } else if (nums[i] == candidate) {
          count++;
        } else {
          count--;
        }
      }
      return candidate;
    }
  }
}