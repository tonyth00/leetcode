import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
public class Solution743 {
  public static void main(String[] args) {
    int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
    System.out.println(new Solution().networkDelayTime(times, 4, 2));
  }

  static class Solution {
    /**
     * Nodes are labelled 1 to N.
     */
    public int networkDelayTime(int[][] times, int N, int K) {
      List<int[]>[] adj = new List[N + 1];
      for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
      for (int[] time : times) {
        int u = time[0], v = time[1], w = time[2];
        adj[u].add(new int[] {v, w});
      }

      Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
      
      int[] dist = new int[N + 1];
      boolean[] visited = new boolean[N + 1];
      for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
      dist[K] = 0;
      queue.add(new int[] {K, dist[K]});

      while (!queue.isEmpty()) {
        int[] token = queue.remove();
        int u = token[0];
        if (visited[u]) continue;
        visited[u] = true;

        for (int[] edge : adj[u]) {
          int v = edge[0], w = edge[1];
          // relax
          if (dist[v] > dist[u] + w) {
            dist[v] = dist[u] + w;
            queue.add(new int[] {v, dist[v]});
          }
        }
      }

      int max = Integer.MIN_VALUE;
      for (int i = 1; i <= N; i++) max = Math.max(max, dist[i]);

      return max == Integer.MAX_VALUE ? -1 : max;
    }
  }
}
