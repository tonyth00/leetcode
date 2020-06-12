import java.util.Deque;
import java.util.ArrayDeque;
public class Solution547 {
  public static void main(String[] args) {
    int[][] M = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    System.out.println(new Solution().findCircleNum3(M));
  }

  static class Solution {
    /**
     * Intuition: BFS flood reachable nodes starting at each node. After each flood, increment the count
     * Time and space complexity same as DFS.
     */
    public int findCircleNum3(int[][] adj) {
      int n = adj.length;
      int count = 0;
      boolean[] visited = new boolean[n];

      Deque<Integer> queue = new ArrayDeque<>();
      for (int u = 0; u < n; u++) {
        if (!visited[u]) {
          queue.add(u);
          visited[u] = true;
          while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int v = 0; v < n; v++) {
              if (adj[node][v] == 1 && !visited[v]) {
                queue.add(v);
                visited[v] = true;
              }
            }
          }
          count++;
        }
      }
      return count;


    }

    /**
     * Intuition: DFS Flood reachable nodes starting at each node. After each flood, increment the
     * count.
     * O(n^2) time because we visit every node at least once, and since it's an adj matrix, we inspect 
     * n times per node. For adj list this would have been O(V + E)
     * O(n) space due to visited matrix, but also due to implicit recursive stack. In the worst case,
     * we only have one friend circle, so we can potentially have n calls on the recursive stack.
     */
    public int findCircleNum(int[][] adj) {
      int n = adj.length;
      int count = 0;
      boolean[] visited = new boolean[n];
      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          dfs(adj, visited, i);
          count++;
        }
      }
      return count;
    }

    private void dfs(int[][] adj, boolean[] visited, int u) {
      int n = adj[u].length;
      for (int v = 0; v < n; v++) {
        if (adj[u][v] == 1 && !visited[v]) {
          visited[v] = true;
          dfs(adj, visited, v);
        }
      }
    }

    /**
     * Intuition - Union Find Start with n groups, decrease number of groups by 1 everytime a union
     * occurs 
     * O(n^2) time due to iterating over adj matrix. Union find with path compression and
     * weighted union is amortized O(1). 
     * O(n) space due to size/id array for union-find structure.
     */
    public int findCircleNum2(int[][] adj) {
      int n = adj.length;
      int[] id = new int[n];
      int[] size = new int[n];
      for (int i = 0; i < n; i++) {
        id[i] = i;
        size[i] = 1;
      }
      int numGroups = n;

      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (adj[i][j] == 1) {
            int p = find(id, i);
            int q = find(id, j);
            if (p == q)
              continue;

            if (size[p] > size[q]) {
              size[p] += size[q];
              id[q] = p;
            } else {
              size[q] += size[p];
              id[p] = q;
            }

            numGroups--;

          }
        }
      }
      return numGroups;
    }

    private int find(int[] id, int p) {
      while (p != id[p]) {
        id[p] = id[id[p]];
        p = id[p];
      }
      return p;
    }
  }
}
