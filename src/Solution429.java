import shared.nary.Node;
import shared.Helper;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution429 {
  public static void main(String[] args) {
    Node root = Helper.createNaryTree(new Integer[] {1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8,
        null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14});
    System.out.println(new Solution().levelOrder(root));
  }

  static class Solution {
    public List<List<Integer>> levelOrder(Node root) {
      List<List<Integer>> res = new ArrayList<>();
      Deque<Node> queue = new ArrayDeque<>();
      if (root == null) return res;
      queue.add(root);

      while (!queue.isEmpty()) {
        List<Integer> list = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          Node cur = queue.remove();
          list.add(cur.val);
          for (Node child : cur.children) queue.add(child);
        }
        res.add(list);
      }

      return res;
    }
  }
}
