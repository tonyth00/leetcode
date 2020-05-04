import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import shared.TreeNode;
import shared.Helper;
public class Solution863 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    System.out.println(new Solution().distanceK(root, root.left, 2));
  }

  static class Solution {

    /**
     * Intuition:
     * - Solve as graph problem. 
     * - Build graph using DFS
     * - Use BFS/DFS from target node to find all nodes distance k from target.
     * - O(n) time and space.
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
      List<Integer>[] adj = new List[501];
      buildGraph(root, adj, -1);

      List<Integer> res = new ArrayList<>();
      // dfsFromSource(adj, target.val, K, res, -1);
      bfsFromSource(adj, res, target.val, K);
      return res;
    }

    private void bfsFromSource(List<Integer>[] adj, List<Integer> res, int source, int K) {
      Deque<Integer> queue = new ArrayDeque<>();
      queue.add(source);
      int level = 0;
      Set<Integer> seen = new HashSet<>(); // O(n)
      while (!queue.isEmpty() && level <= K) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          int u = queue.remove();
          seen.add(u);
          if (level == K) res.add(u);
          for (int v : adj[u]) {
            if (!seen.contains(v)) queue.add(v);
          }
        }
        level++;
      }
    }

    /**
     * O(n) time if K = INF, we traverse entire tree
     * O(k) space due to recursion stack.
     */
    private void dfsFromSource(List<Integer>[] adj, int u, int K, List<Integer> res, int parent) {
      if (K == 0) {
        res.add(u);
      } else {
        for (int v : adj[u]) {
          if (v == parent) continue;
          dfsFromSource(adj, v, K - 1, res, u);
        }
      }
    }

    /**
     * O(n) time since we visit each node once, and |E| = N - 1
     */
    private void buildGraph(TreeNode node, List<Integer>[] adj, int parent) {
      if (node == null) return;
      if (adj[node.val] == null) adj[node.val] = new ArrayList<>();
      if (parent >= 0) {
        adj[node.val].add(parent);
        adj[parent].add(node.val);
      }

      buildGraph(node.left, adj, node.val);
      buildGraph(node.right, adj, node.val);
    }
  }
}
