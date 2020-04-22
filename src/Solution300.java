import java.util.Arrays;
public class Solution300 {
  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
  }

  static class Solution {
    /**
     * Brute Force:
     * Test every subset of the array. For each subset, check if it is strictly increasing.
     * O(2^n) time since there are 2^n subsets.
     */

    /**
     * DP solution, O(n^2)
     * Intuition:
     * Initialize a dp array of 1s. Each index represents max length of LIS inclusive of nums[index].
     * The minimum length is 1 (number by itself). For each index, check if a previous index has a value
     * smaller than itself. True implies an increasing subsequence can be generated from a previous increasing
     * subsequence and the current index. Update the maximum at current index.
     * 
     * Return max(dp)
     */
    public int lengthOfLIS2(int[] nums) {
      if (nums.length == 0) return 0;
      int[] dp = new int[nums.length];
      Arrays.fill(dp, 1);
      for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
          if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      int max = Integer.MIN_VALUE;
      for (int num : dp) max = Math.max(max, num);
      return max;
    }
    
    /**
     * Intuition:
     * Patience sort
     * Create a running array of pending subsequences.
     * Greedy insert new element to the left-most pile that has a higher value.
     * 
     * Points:
     * If new element is the smallest element, it cannot be attached to any
     * pre-existing subsequence, therefore it starts a new subsequence on the
     * left-most pile.
     * 
     * If new element is the largest element, append it to the longest subsequence seen 
     * so far by creating a new pile to the right.
     */
    public int lengthOfLIS(int[] nums) {
      int[] arr = new int[nums.length];
      int length = 0;
      for (int num : nums) {
        int index = search(arr, 0, length - 1, num);
        arr[index] = num;
        if (index == length) length++;
      }
      return length;
    }

    private int search(int[] arr, int L, int R, int target) {
      while (L <= R) {
        int M = L + (R - L)/2;
        if (target > arr[M]) {
          L = M + 1;
        } else if (target < arr[M]) {
          R = M - 1;
        } else {
          return M;
        }
      }
      return L;
    }
  }
}