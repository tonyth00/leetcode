/**
 * Solution33
 */
public class Solution33 {

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
  }

  static class Solution {
    /**
     * Intuition:
     * If A[m] == k, return index
     * If A[l] < A[m], l -> m is strictly increasing.
     *  - If A[l] <= k <= A[m] search here
     *  - else search elsewhere
     * If A[l] > A[m], m -> r is strictly increasing.
     *  - If A[m] <= k <= A[r] search here
     *  - else search elsewhere
     * 
     * Once loop ends, A[l] and A[r] haven't been searched yet.
     * Check if either A[l] or A[r] is k, otherwise return -1.
     */
    public int search(int[] A, int k) {
      if (A == null || A.length == 0) return -1;
      int l = 0;
      int r = A.length - 1;
      while (l + 1 < r) {
        int m = l + (r - l)/2;
        if (A[m] == k) return m;
        if (A[l] < A[m]) {
          if (A[l] <= k && k <= A[m]) r = m;
          else l = m;
        } else if (A[l] > A[m]) {
          if (A[m] <= k && k <= A[r]) l = m;
          else r = m;
        }
      }
      
      if (A[l] == k) return l;
      if (A[r] == k) return r;
      return -1;
    }
  }
}
