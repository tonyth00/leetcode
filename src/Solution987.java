import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import shared.Helper;
import shared.TreeNode;

/**
 * Solution987
 */
public class Solution987 {

  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {1, 2, 3, 4, 5, 6, 7});
    System.out.println(new Solution().verticalTraversal(root));
  }

  static class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null)
        return res;

      PriorityQueue<PNode> queue = new PriorityQueue<>((a, b) -> {
        if (a.x != b.x) {
          return Integer.compare(a.x, b.x);
        } else if (a.y != b.y) {
          return Integer.compare(a.y, b.y);
        } else {
          return Integer.compare(a.val, b.val);
        }
      });
      dfs(root, 0, 0, queue);

      PNode prev = null;
      List<Integer> list = null;
      while (!queue.isEmpty()) {
        PNode node = queue.remove();
        if (prev == null || prev.x != node.x) {
          list = new ArrayList<>();
          res.add(list);
        }
        list.add(node.val);
        prev = node;
      }
      return res;
    }

    private void dfs(TreeNode node, int x, int y, PriorityQueue<PNode> queue) {
      if (node == null)
        return;

      queue.add(new PNode(x, y, node.val));
      dfs(node.left, x - 1, y + 1, queue);
      dfs(node.right, x + 1, y + 1, queue);
    }

    class PNode {
      public int x;
      public int y;
      public int val;

      public PNode(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
      }
    }

    // bfs
    public List<List<Integer>> verticalTraversal2(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null)
        return res;

      Queue<Node> queue = new LinkedList<>();
      queue.add(new Node(0, 0, root));

      Map<Integer, List<Integer>> map = new HashMap<>();

      while (!queue.isEmpty()) {
        int size = queue.size();
        Map<Integer, List<Integer>> xMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
          Node node = queue.remove();
          if (!xMap.containsKey(node.x))
            xMap.put(node.x, new ArrayList<>());
          xMap.get(node.x).add(node.node.val);

          if (node.node.left != null)
            queue.add(new Node(node.x - 1, node.y - 1, node.node.left));
          if (node.node.right != null)
            queue.add(new Node(node.x + 1, node.y - 1, node.node.right));
        }

        for (int x : xMap.keySet()) {
          if (!map.containsKey(x))
            map.put(x, new ArrayList<>());
          List<Integer> list = xMap.get(x);
          Collections.sort(list);
          map.get(x).addAll(list);
        }
      }

      List<Integer> keys = new ArrayList<>(map.keySet());
      Collections.sort(keys);

      for (Integer x : keys) {
        res.add(map.get(x));
      }

      return res;
    }

    class Node {
      public int x;
      public int y;
      public TreeNode node;

      public Node(int x, int y, TreeNode node) {
        this.node = node;
        this.x = x;
        this.y = y;
      }
    }
  }
}
