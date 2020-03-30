class Solution941 {
  public static void main(String[] args) {
    System.out.println(new Solution().validMountainArray(new int[] {0, 2, 3, 4, 5, 2, 1, 0}));
  }

  static class Solution {
    public boolean validMountainArray(int[] A) {
      if (A == null || A.length < 3) return false;
      int n = A.length;
      int left = 0;
      int right = n - 1;
      while (left < n - 1 && A[left] < A[left + 1]) left++;
      while (right > 0 && A[right - 1] > A[right]) right--;
      return left == right && left > 0 && right < n - 1;
    }
  }
}