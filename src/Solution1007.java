class Solution1007 {
  public static void main(String[] args) {
    int[] A = {2,1,2,4,2,2};
    int[] B = {5,2,6,2,3,2};
    System.out.println(new Solution().minDominoRotations(A, B));
  }

  static class Solution {
    public int minDominoRotations(int[] A, int[] B) {
      int min = Integer.MAX_VALUE;
      min = Math.min(min, getRotations(A, B, A[0]));
      min = Math.min(min, getRotations(B, A, A[0]));
      if (min != Integer.MAX_VALUE) return min;

      min = Math.min(min, getRotations(A, B, B[0]));
      min = Math.min(min, getRotations(B, A, B[0]));

      return min == Integer.MAX_VALUE ? -1 : min;

    }

    private int getRotations(int[] A, int[] B, int value) {
      int count = 0;
      for (int i = 0; i < A.length; i++) {
        if (A[i] == value) continue;
        else if (B[i] == value) {
          count++;
        } else {
          return Integer.MAX_VALUE;
        }
      }

      return count;
    }
  }
}