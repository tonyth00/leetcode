import java.util.Arrays;

import shared.Helper;

/**
 * Solution435
 */
public class Solution435 {

  public static void main(String[] args) {
    int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
    System.out.println(new Solution().eraseOverlapIntervals(intervals));
  }

  static class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      if (intervals == null || intervals.length < 2) return 0;
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
      int count = 0;

      for (int i = 0, j = 1; j < intervals.length; j++) {
        if (intervals[j][0] < intervals[i][1]) {
          count++;
        } else {
          i = j;
        }
      }

      return count;
    }
  }
}