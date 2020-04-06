
public class Solution4 {
  public static void main(String[] args) {
    int[] nums1 = {1, 3};
    int[] nums2 = {2};
    System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
  }

  static class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
      if (A.length > B.length) {
        int[] temp = A;
        A = B;
        B = temp;
      }

      int aLen = A.length, bLen = B.length;
      boolean isEven = (aLen + bLen) % 2 == 0;
      
      int leftLen = (aLen + bLen + 1) / 2;
      int start = 0;
      int end = A.length - 1;
      while (true) {
        int Ar = start + (end - start) / 2;
        int Al = Ar - 1;
        int Br = leftLen - Ar;
        int Bl = Br - 1;
        int[] a = {Al == -1 ? Integer.MIN_VALUE : A[Al], Ar == A.length ? Integer.MAX_VALUE : A[Ar] };
        int[] b = {Bl == -1 ? Integer.MIN_VALUE : B[Bl], Br == B.length ? Integer.MAX_VALUE : B[Br] };
        if (b[0] > a[1]) start = Ar + 1;
        else if (a[0] > b[1]) end = Ar - 1;
        else {
          if (isEven) {
            return 0.5 * (Math.max(a[0], b[0]) + Math.min(a[1], b[1]));
          } else {
            return Math.max(a[0], b[0]);
          }
        }
      }
    }
  }
}