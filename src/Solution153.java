/**
 * Solution153
 */
public class Solution153 {

  public static void main(String[] args) {
    System.out.println(new Solution().findMin(new int[] { 0, 1, 2, 3, 4 }));
  }

  static class Solution {
    /**
     * Invariants:
     * No duplicates in the array
     * Since we use (l + 1 < r) template, l != m so A[l] != A[m] 
     * 
     * Intuition:
     * - Find the breakpoint, by removing strictly increasing subarrays from
     * the search range.
     * - Check if A[l] < A[r]. If it is, l -> r is strictly increasing
     * so l is the min element
     * - Otherwise, breakpoint occurs somewhere between l and r. Binary
     * search in this range.
     * - If we continue to do this, we're left with two elements:
     * A[l] and A[r] with breakpoint in between. A[l] > A[r] always, so return A[r]
     */
    public int findMin(int[] A) {
      int l = 0;
      int r = A.length - 1;

      if (A[l] < A[r]) return A[l]; // l -> r strictly increasing

      while (l + 1 < r) {
        int m = l + (r - l)/2;
        if (A[l] < A[m]) l = m; // l -> m strictly increasing
        else if (A[l] > A[m]) r = m; // m -> r strictly increasing
      }

      return A[r];
    }
  }
}