import java.util.Arrays;

/**
 * Solution252
 */
public class Solution252 {
  public static void main(String[] args) {
    System.out.println(new Solution().canAttendMeetings(new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } }));
  }

  static class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
      for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] < intervals[i - 1][1]) return false;
      }
      return true;
    }
  }
}