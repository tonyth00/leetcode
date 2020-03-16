/**
 * Solution35
 */
public class Solution35 {

  public static void main(String[] args) {
    System.out.println(new Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 2));
  }

  static class Solution {
    public int searchInsert(int[] nums, int target) {
      int start = 0;
      int end = nums.length;

      while (start < end) {
        int mid = (end + start)/2;
        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] < target) {
          start = mid + 1;
        } else {
          end = mid;
        }
      }

      return start;
    }
  }
}