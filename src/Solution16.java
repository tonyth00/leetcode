import java.util.Arrays;
public class Solution16 {
  public static void main(String[] args) {
    int[] nums = {-1, 2, 1, -4};
    int target = 1;
    System.out.println(new Solution().threeSumClosest(nums, target));
  }

  static class Solution {
    public int threeSumClosest(int[] nums, int target) {
      int n = nums.length;
      Arrays.sort(nums);
      int best = nums[0] + nums[1] + nums[2];
      
      for (int k = 0; k < n - 2; k++) {
        int i = k + 1;
        int j = n - 1;
        while (i < j) {
          int cur = nums[i] + nums[j] + nums[k];
          if (Math.abs(best - target) > Math.abs(cur - target)) {
            best = cur;
          }

          if (cur > target) j--;
          else if (cur < target) i++;
          else return best;
        }
      }

      return best;
    }
  }
}