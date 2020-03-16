import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution15a
 */
public class Solution15 {

  public static void main(String[] args) {
    System.out.println(new Solution().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
  }

  static class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();
      for (int i = 0; i < nums.length - 2; i++) {
        if (nums[i] > 0) break;
        int base = nums[i];
        int L = i + 1;
        int R = nums.length - 1;

        while (L < R) {
          if (nums[L] + nums[R] == -base) {
            res.add(Arrays.asList(base, nums[L], nums[R]));
            while (L < R && nums[R] == nums[R - 1]) R--;
            while (L < R && nums[L] == nums[L + 1]) L++;
            R--;
            L++;
          } else if (nums[L] + nums[R] < -base) {
            L++;
          } else {
            R--;
          }
        }

        while (i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
      }

      return res;
    }
  }
}