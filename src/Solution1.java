
import java.util.HashMap;
import java.util.Map;

public class Solution1 {

  public static void main(String[] args) {
    int[] nums = { 2, 7, 11, 15 };
    Solution s = new Solution();
    
    for (int num : s.twoSum(nums, 9)) {
      System.out.print(num + " ");
    }
  }

  static class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
          return new int[] {i, map.get(nums[i])};
        } else {
          map.put(target - nums[i], i);
        }
      }

      return new int[] {0, 0};
    }
  }
}