import java.util.*;
class Solution261 {
  public static void main(String[] args) {
    System.out.println(new Solution().validTree(5, new int[][] {{0,1}, {0,2}, {0,3}, {1,4}}));
  }

  static class Solution {
    public boolean validTree(int n, int[][] edges) {
      if (edges.length != n - 1) return false; // Number of edges in a tree is strictly equal to number of nodes minus 1.
      List<List<Integer>> adj = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
      }
      for (int[] e : edges) {
        adj.get(e[0]).add(e[1]);
        adj.get(e[1]).add(e[0]);
      }
      
      Set<Integer> visited = new HashSet<>();
      if (hasCycle(0, adj, visited, -1)) return false;

      return visited.size() == n;

    }

    private boolean hasCycle(int u, List<List<Integer>> adj, Set<Integer> visited, int parent) {
      if (visited.contains(u)) return true;
      
      visited.add(u);
      for (int v : adj.get(u)) {
        if (v != parent && hasCycle(v, adj, visited, u)) return true;
      }

      return false;
    }
  }
}