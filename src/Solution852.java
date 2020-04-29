/**
 * Solution852
 */
public class Solution852 {

  public static void main(String[] args) {
    System.out.println(new Solution().peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
  }

  static class Solution {
    public int peakIndexInMountainArray(int[] A) {
      int L = 0;
      int R = A.length;
      while (L < R) {
        int M = L + (R - L)/2;
        if (A[M] < A[M + 1]) L = M + 1;
        else R = M;
      }
      return L;
    }
  }
}