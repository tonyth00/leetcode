import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import shared.Helper;

public class Solution1057 {
  public static void main(String[] args) {
    int[][] workers = {{240,446},{745,948},{345,136},{341,68},{990,165},{165,580},{133,454},{113,527}};
    int[][] bikes = {{696,140},{95,393},{935,185},{767,205},{387,767},{214,960},{804,710},{956,307}};
    Helper.print(new Solution().assignBikes(workers, bikes));
  }

  static class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
      int W = workers.length;
      int B = bikes.length;
      Map<Integer, List<int[]>> buckets = new HashMap<>();
      for (int i = 0; i < W; i++) {
        for (int j = 0; j < B; j++) {
          int dist = man(workers[i], bikes[j]);
          if (!buckets.containsKey(dist)) buckets.put(dist, new ArrayList<>());
          buckets.get(dist).add(new int[] {i, j});
        }
      }

      boolean[] usedWorker = new boolean[W];
      boolean[] usedBike = new boolean[B];
      int[] res = new int[W];
      
      List<Integer> dists = new ArrayList<>(buckets.keySet());
      Collections.sort(dists);

      int count = 0;
      for (int dist : dists) {
        for (int[] pair : buckets.get(dist)) {
          int w = pair[0], b = pair[1];
          if (usedWorker[w] || usedBike[b]) continue;
          res[w] = b;
          usedWorker[w] = usedBike[b] = true;
          count++;
          if (count == W) return res;
        }
      }

      return res;
    }

    private int man(int[] a, int[] b) {
      return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
  }
}