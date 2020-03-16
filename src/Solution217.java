import java.util.HashSet;

/**
 * Solution217
 */
public class Solution217 {

  public static void main(String[] args) {
    System.out.println(new Solution().containsDuplicate(new int[] { 3, 3 }));
  }

  static class Solution {
    public boolean containsDuplicate(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i])) return true;
        set.add(nums[i]);
      }

      return false;
    }
  }
}