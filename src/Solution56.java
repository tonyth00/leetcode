import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import shared.Helper;

/**
 * Solution56
 */
public class Solution56 {

  public static void main(String[] args) {
    Helper.print(new Solution().merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }));
  }

  static class Solution {
    public int[][] merge(int[][] intervals) {
      if (intervals == null || intervals.length < 2) return intervals;
      Arrays.sort(intervals, (a,  b) -> Integer.compare(a[0], b[0]));
      List<int[]> res = new ArrayList<>();
      int[] newInterval = intervals[0];
      res.add(newInterval);
      for (int[] interval : intervals) {
        if (interval[0] <= newInterval[1]) {
          newInterval[1] = Math.max(newInterval[1], interval[1]);
        } else {
          newInterval = interval;
          res.add(newInterval);
        }
      }
      return res.toArray(new int[res.size()][2]);
    }
  }
}