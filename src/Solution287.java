import java.util.HashSet;

/**
 * Solution287
 */
public class Solution287 {

  public static void main(String[] args) {
    System.out.println(new Solution().findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
  }

  static class Solution {
    public int findDuplicate(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
        if (!set.contains(nums[i])) {
          set.add(nums[i]);
        } else {
          return nums[i];
        }
      }
      return -1;
    }
  }
}