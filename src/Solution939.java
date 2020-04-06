import java.util.HashSet;
import java.util.Set;
import java.awt.Point;
/**
 * Solution939
 */
public class Solution939 {

  public static void main(String[] args) {
    System.out.println(
        new Solution().minAreaRect(new int[][] {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}}));
  }

  static class Solution {
    public int minAreaRect(int[][] points) {
      int minArea = Integer.MAX_VALUE;
      Set<Point> set = new HashSet<>();
      for (int[] point : points) set.add(new Point(point[0], point[1]));

      for (int i = 0; i < points.length; i++) {
        for (int j = i + 1; j < points.length; j++) {
          int[] p1 = points[i];
          int[] p2 = points[j];
          if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
          int area = Math.abs((p1[0] - p2[0])*(p1[1] - p2[1]));
          if (area >= minArea) continue;
          // Avoid creating new objects until absolutely necessary to save computational time
          if (set.contains(new Point(p1[0],p2[1])) && set.contains(new Point(p2[0], p1[1]))) {  
            minArea = Math.min(minArea, area);
          }
        }
      }
      return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
  }
}
