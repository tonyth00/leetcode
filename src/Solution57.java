import java.util.ArrayList;
import java.util.List;

import shared.Helper;

/**
 * Solution57
 */
public class Solution57 {

  public static void main(String[] args) {
    int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
    Helper.print(new Solution().insert(intervals, new int[] { 4, 8 }));
  }

  static class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> res = new ArrayList<>();
      int i = 0;
      while (i < intervals.length && intervals[i][1] < newInterval[0]) res.add(intervals[i++]);
      while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
      }
      res.add(newInterval);
      while (i < intervals.length) res.add(intervals[i++]); 

      return res.toArray(new int[res.size()][2]);
    }
  }
}