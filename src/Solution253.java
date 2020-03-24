
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution253 {
  public static void main(String[] args) {
    int[][] intervals = {{0, 30},{5, 10},{15, 20}};
    System.out.println(new Solution().minMeetingRooms2(intervals));
  }

  static class Solution {
    public int minMeetingRooms(int[][] intervals) {
      if (intervals == null || intervals.length == 0) return 0;
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      for (int[] interval : intervals) {
        if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
          minHeap.remove();
        }
        minHeap.add(interval[1]);
      }

      return minHeap.size();
    }

    public int minMeetingRooms2(int[][] intervals) {
      if (intervals == null || intervals.length == 0) return 0;
      int len = intervals.length;
      int[] starts = new int[len];
      int[] ends = new int[len];
      for (int i = 0; i < len; i++) {
        starts[i] = intervals[i][0];
        ends[i] = intervals[i][1];
      }
      Arrays.sort(starts);
      Arrays.sort(ends);
      int endIndex = 0;
      int numRooms = 0;
      for (int startIndex = 0; startIndex < len; startIndex++) {
        if (starts[startIndex] < ends[endIndex]) {
          numRooms++;
        } else {
          endIndex++;
        }
      }
      return numRooms;
    }
  }
}