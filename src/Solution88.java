import shared.Helper;

/**
 * Solution88
 */
public class Solution88 {

  public static void main(String[] args) {
    int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    int[] nums2 = { 2, 5, 6 };

    new Solution().merge(nums1, 3, nums2, 3);
    Helper.print(nums1);
  }

  static class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int j = n - 1;
      int i = m - 1;
      int k = n + m - 1;

      while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
          nums1[k] = nums1[i--];
        } else {
          nums1[k] = nums2[j--];
        }

        k--;
      }
      while (j >= 0) {
        nums1[k] = nums2[j--];
        k--;
      }

    }
  }
}