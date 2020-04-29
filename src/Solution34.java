import shared.Helper;
public class Solution34 {
  public static void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    Helper.print(new Solution().searchRange(nums, 9));  
  }

  static class Solution {
    public int[] searchRange(int[] nums, int target) {
      int left = search(nums, target, true);
      if (left == nums.length || nums[left] != target) return new int[] {-1, -1};
      int right = search(nums, target, false);
      return new int[] {left, right};
    }

    /**
     * Intuition:
     * - For leftmost target, we let G(x) = A[x] >= target. Returns first index where G(x) is true.
     * - For rightmost target, we let G(x) = A[x] > target. Returns first index where G(x) is true.
     * Since we're looking for first element greater than target, once we find it, return x - 1 which is rightmost target.
     */
    private int search(int[] A, int target, boolean left) {
      int l = 0;
      int r = A.length;
      while (l < r) {
        int m = l + (r - l)/2;

        if (left) {
          if (A[m] >= target) r = m;
          else l = m + 1;
        } else {
          if (A[m] > target) r = m;
          else l = m + 1;
        }
      }

      return left ? l : l - 1;
    }
  }
}