import shared.Helper;

public class Solution684 {
  public static void main(String[] args) {
    int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
    Helper.print(new Solution().findRedundantConnection(edges));
  }

  static class Solution {
    /**
     * Intuition: Union-find. If an edge doesn't create a cycle within a component,
     * union the two components. If it does, return the edge.
     * O(E) time and space
     */
    public int[] findRedundantConnection(int[][] edges) {
      int n = edges.length;
      int[] id = new int[n + 1];
      for (int i = 0; i < id.length; i++) {
        id[i] = i;
      };
      for (int[] edge : edges) {
        int p = find(id, edge[0]);
        int q = find(id, edge[1]);
        if (p == q) return edge;
        id[p] = q; // union
      }

      return new int[] {-1, -1};

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
