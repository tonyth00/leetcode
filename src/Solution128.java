import java.util.*;
class Solution128 {
  public static void main(String[] args) {
    System.out.println(new Solution().longestConsecutive(new int[] {10, 11, 12, 4, 2, 3, 1}));
  }

  static class Solution {
    public int longestConsecutive(int[] nums) {
      if (nums == null) return 0;

      int maxLen = 0;

      Set<Integer> set = new HashSet<>();
      for (int num : nums) set.add(num);
      
      for (int i = 0; i < nums.length; i++) {
        if (!set.contains(nums[i] - 1)) {
          int j = nums[i];
          while (set.contains(j)) {
            j++;
          }
          maxLen = Math.max(maxLen, j - nums[i]);
        }
      }
      return maxLen;
      
    }
  }
}