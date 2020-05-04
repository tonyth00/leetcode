import java.util.Map;
import java.util.HashMap;
public class Solution560 {
  public static void main(String[] args) {
    int[] nums = {1, 1, 1};
    System.out.println(new Solution().subarraySum(nums, 2));
  }

  static class Solution {

    /**
     * Intuition:
     * Keep a prefix sum which is the running sum from start of array.
     * If running sum is equal to k, subarray sum [0, j] = k, so count++.
     * If curSum - k is in the HashMap, it means that subarray sum [i, j]
     * = k for some index i. Because there could be more than one index i 
     * where this is true, increment count by the number of occurrences of this.
     * 
     * Assume array = [2, 3, 2, -2, -1,  8] and k = 7
     * Prefix array = [2, 5, 7,  5,  4, 12] (This is the running sum)
     * 
     * At j = 2, curSum = k, so count++
     * 
     * By the time we reach the last index j = 5, map contains {2: 1, 5: 2, 7: 1, 6: 1}
     * As we hit the last index, curSum = 12 != k. No count++
     * However, curSum - k = 5 occurs in the map. The count is 2. 
     * Therefore, there are two occurrences where the running sum 
     * was 5 earlier in the array. These are at index 1 and 3:
     * [2,   3,  2, -2,  -1,  8]
     * |<--5-->|<------k------>|
     * |<-------5------>|<-k-->|
     * Therefore, increment the count by number of occurrences.
     * 
     * The algorithm cleverly subtracts two running sums, and if the result is k
     * then a new subarray that sums to k has been found.
     * 
     * Finally, map[curSum]++; // used by indices further down
     * 
     * O(n) time O(n) space
     */
    public int subarraySum(int[] nums, int k) {
      int curSum = 0;
      int count = 0;
      
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        curSum += num;
        if (curSum == k) count++;
        count += map.getOrDefault(curSum - k, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
      }

      return count;
    }
    /**
     * O(n^2) time O(1) space
     * Intuition:
     * 
     */
    public int subarraySum2(int[] nums, int k) {
      int n = nums.length;
      int count = 0;
      for (int i = 0; i < n; i++) {
        int prefixSum = 0;
        for (int j = i; j < n; j++) {
          prefixSum += nums[j];
          if (prefixSum == k) count++;
        }
      }
      return count;
    }
  }
}
