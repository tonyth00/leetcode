import java.util.*;
class Solution448 {
  public static void main(String[] args) {
    System.out.println(new Solution().findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
  }

  static class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        int index = Math.abs(nums[i]) - 1;
        if (nums[index] > 0) nums[index] = -nums[index];
      }

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) res.add(i + 1);
      }
      return res;
    }
  }
}