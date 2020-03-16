import java.util.HashMap;

/**
 * Solution219
 */
public class Solution219 {

  public static void main(String[] args) {
    System.out.println(new Solution().containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
  }

  static class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
        Integer prev = map.put(nums[i], i);
        if (prev != null && Math.abs(i - prev) <= k) return true;
      }

      return false;
    }
  }
}