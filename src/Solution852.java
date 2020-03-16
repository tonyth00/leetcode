/**
 * Solution852
 */
public class Solution852 {

  public static void main(String[] args) {
    System.out.println(new Solution().peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
  }

  static class Solution {
    public int peakIndexInMountainArray(int[] A) {
      int start = 0;
      int end = A.length - 1;

      while (start < end) {
        int mid = start + (end - start) / 2;

        if (A[mid] < A[mid + 1]) {
          start = mid + 1;
        } else {
          end = mid;
        }
      }

      return start;
    }
  }
}