class Solution323 {
  public static void main(String[] args) {
    System.out.println(new Solution().countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
  }

  static class Solution {
    public int countComponents(int n, int[][] edges) {
      int[] parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
      for (int[] edge : edges) {
        int p1 = find(parent, edge[0]);
        int p2 = find(parent, edge[1]);
        if (p1 != p2) {
          // union
          parent[p1] = p2;
          n--;
        }
      }

      return n;
    }

    private int find(int[] parent, int u) {
      while (parent[u] != u) {
        parent[u] = parent[parent[u]];
        u = parent[u];
      }
      return u;
    }
  }
}