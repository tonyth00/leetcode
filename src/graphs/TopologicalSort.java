package graphs;
import java.util.*;

class TopologicalSort {
  public static void main(String[] args) {
    int[][] edges = {{1, 2}, {2, 3}, {3, 6}, {4, 1}, {4, 5}, {5, 2}, {5, 3}};
    List<Integer>[] adj = new List[6 + 1];
    for (int i = 0; i < adj.length; i++) adj[i] = new ArrayList<>();
    for (int[] e : edges) adj[e[0]].add(e[1]);

    System.out.println(bfsSort(adj, 6));

    List<Integer> res = dfsSort(adj, 6);
    Collections.reverse(res);
    // System.out.println(res);
  }

  static List<Integer> bfsSort(List<Integer>[] adj, int numNodes) {
    List<Integer> res = new ArrayList<>();
    int[] indegree = new int[numNodes + 1];
    for (int i = 1; i <= numNodes; i++) {
      for (int v : adj[i]) indegree[v]++;
    }
    
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= numNodes; i++) {
      if (indegree[i] == 0) queue.add(i);
    }

    while (!queue.isEmpty()) {
      int u = queue.remove();
      res.add(u);
      for (int v : adj[u]) {
        indegree[v]--;
        if (indegree[v] == 0) queue.add(v);
      }
    }

    for (int i = 1; i <= numNodes; i++) if (indegree[i] > 0) return new ArrayList<>();

    return res;
  }

  static List<Integer> dfsSort(List<Integer>[] adj, int numNodes) {
    int[] state = new int[numNodes + 1];
    List<Integer> res = new ArrayList<>();

    List<Integer> nodes = new ArrayList<>();
    for (int u = 1; u <= numNodes; u++) nodes.add(u);

    Random rand = new Random();
    while (nodes.size() > 0) {
      int u = nodes.remove(rand.nextInt(nodes.size()));
      if (state[u] == 0) {
        if (!dfs(adj, state, res, u)) return new ArrayList<>();
      }
    }
    return res;
  }

  static boolean dfs(List<Integer>[] adj, int[] state, List<Integer> res, int u) {
    state[u] = 1;
    for (int v : adj[u]) {
      if (state[v] == 1) return false; // cycle
      if (state[v] == 2) continue; // visited
      if (!dfs(adj, state, res, v)) return false;
    }
    res.add(u);
    state[u] = 2;

    return true;
  }

  
}