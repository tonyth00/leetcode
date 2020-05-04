/**
 * Solution154
 */
public class Solution154 {

  public static void main(String[] args) {
    System.out.println(new Solution().findMin(new int[] { 10, 1, 10, 10, 10 }));
  }

  static class Solution {
    /**
     * Invariant:
     * - We have duplicates.
     * 
     * Intuition:
     * Since we have duplicates A[l] == A[m]
     * is now possible. In those instances, just
     * increment l++.
     * 
     */
    public int findMin(int[] A) {
      int L = 0;
      int R = A.length - 1;

      while (L + 1 < A.length && A[L] == A[R]) L++; // skip breakpoints that break between duplicate elements.

      if (A[L] < A[R]) return A[L];

      while (L + 1 < R) {
        int M = L + (R - L)/2;
        if (A[L] < A[M]) L = M;
        else if (A[L] > A[M]) R = M;
        else L++;
      }

      return A[R];
    }
  }
}