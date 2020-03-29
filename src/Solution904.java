import java.util.*;

class Solution904 {
  public static void main(String[] args) {
    System.out.println(new Solution().totalFruit(new int[] { 3,3,3,1,2,1,1,2,3,3,4 }));
  }

  static class Solution {
    public int totalFruit(int[] tree) {
      int max = 0;
      for (int i = -1, j = 0, minIndex = -1; j < tree.length; j++) {
        if (j > 0 && tree[j] != tree[j - 1]) {
          if (minIndex != -1 && tree[minIndex] != tree[j]) i = minIndex; // update sliding window
          minIndex = j - 1;
        }

        max = Math.max(max, j - i);
      }
      return max;
    }
  }
}