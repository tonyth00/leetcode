import java.util.List;
import java.util.ArrayList;
public class Solution797 {
  public static void main(String[] args) {
    int[][] graph = {{1, 2}, {3}, {3}, {}};
    System.out.println(new Solution().allPathsSourceTarget(graph));
  }

  static class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      List<List<Integer>> res = new ArrayList<>();

      List<Integer> cur = new ArrayList<>();
      cur.add(0);
      dfs(graph, res, cur, 0);
      return res;
    }

    private void dfs(int[][] adj, List<List<Integer>> res, List<Integer> cur, int u) {
      int N = adj.length;
      if (u == N - 1) {
        res.add(new ArrayList<>(cur));
      } else {
        for (int v : adj[u]) {
          cur.add(v);
          dfs(adj, res, cur, v);
          cur.remove(cur.size() - 1);
        }
      }
    }
  }
}