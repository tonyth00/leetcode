/**
 * Solution81
 */
public class Solution81 {

  public static void main(String[] args) {
    System.out.println(new Solution().search(new int[] { 3, 1, 1 }, 0));
  }

  static class Solution {
    /**
     * Intuition:
     * - Since duplicates exist, we need to process
     * the event A[l] = A[m], in which case we just
     * increment l++
     */
    public boolean search(int[] A, int k) {
      if (A == null || A.length == 0)  return false;

      int l = 0;
      int r = A.length - 1;

      while (l + 1 < r) {
        int m = l + (r - l)/2;
        if (A[m] == k) return true;
        if (A[l] < A[m]) {
          if (A[l] <= k && k <= A[m]) r = m;
          else l = m;
        } else if (A[l] > A[m]) {
          if (A[m] <= k && k <= A[r]) l = m;
          else r = m;
        } else { // A[l] == A[m]
          l++;
        }
      }

      return A[l] == k || A[r] == k;

    }
  }
}