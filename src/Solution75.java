import shared.Helper;
public class Solution75 {
  public static void main(String[] args) {
    int[] nums = {2, 0, 2, 1, 1, 0};
    new Solution().sortColors(nums);
    Helper.print(nums);
  }

  static class Solution {
    /**
     * Intution:
     * Invariants:
     * Let i = index where [0, i - 1] are 0s
     * Let k = index where [k + 1, n - 1] are 2s
     * i and k are next insertable position.
     * 
     * Iterate through array using j:
     * - If we see a 0, swap j with i. Advance both i and j, because if i == j and nums[i]=nums[j]=0
     * we increment i to maintain the invariant but we cannot have j fall behind. Also, we have seen 
     * everything between i and j, so after swapping, j points to a value we've seen, so increment j
     * - If we see a 2, swap j with k. Decrement k only, because after the swap
     * j contains a value we haven't seen before.
     * - If we see a 1, increment j.
     */
    public void sortColors(int[] nums) {
      int n = nums.length;
      int i = 0;
      int k = n - 1;
      int j = 0;
      while (j <= k) {
        if (nums[j] == 0) swap(nums, i++, j++);
        else if (nums[i] == 2) swap(nums, i, k--);
        else j++;
      }
    }

    private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
}
