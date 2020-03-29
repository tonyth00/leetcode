import java.util.*;

/**
 * Solution219
 */
public class Solution219 {

  public static void main(String[] args) {
    System.out.println(new Solution().containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
  }

  static class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      int n = nums.length;
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
        map.put(nums[i], i);
      }
      return false;
    }
  }
}