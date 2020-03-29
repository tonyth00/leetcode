class Solution905 {
  public static void main(String[] args) {
    System.out.println(new Solution().sortArrayByParity(new int[] {3,1,2,4}));
  }

  static class Solution {
    public int[] sortArrayByParity(int[] A) {
      int i = 0;
      for (int j = 0; j < A.length; j++) {
        if ((A[j] & 1) == 0) {
          int temp = A[j];
          A[j] = A[i];
          A[i] = temp;
          i++;
        }
      }
      return A;
    }
  }
}