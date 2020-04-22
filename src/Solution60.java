import java.util.ArrayList;
import java.util.List;

public class Solution60 {
  public static void main(String[] args) {
    System.out.println(new Solution().getPermutation(4, 10));
  }

  static class Solution {
    /**
     * Intuition:
     * When n = 4, the first 12 permutations is :
     * 1234 2134
     * 1243 2143
     * 1324 2314
     * 1342 2341
     * 1423 2413
     * 1432 2431
     * 
     * Using modulo arithmetic on k, you can decide which value to pluck,
     * remove the value from the list, and repeat
     * 
     * 1. For n digits, there are (n-1)! permutations in each group, so
     * we need to divide k by (n-1)! to find the group index
     * 2. Pluck from remaining elements at that index. Remove the element
     * 3. modulo k by (n-1)! to prepare it for the next iteration.
     */
    public String getPermutation(int n, int k) {
      
      List<Integer> nums = new ArrayList<>();
      int[] fact = new int[n + 1];
      fact[0] = 1;
      for (int i = 1; i <= n; i++) {
        fact[i] = i*fact[i - 1];
        nums.add(i);
      }

      StringBuilder sb = new StringBuilder();
      k -= 1; // makes division/modulo arithmetic easier
      for (int i = n; i >= 1; i--) { // O(n)
        int index = k / fact[i - 1];
        k %= fact[i - 1];
        sb.append(nums.remove(index)); // O(n) remove
      }

      return sb.toString();
    }
  }
}
