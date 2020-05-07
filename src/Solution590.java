import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
import shared.nary.Node;
import shared.Helper;

public class Solution590 {
  public static void main(String[] args) {
    Node root = Helper.createNaryTree(new Integer[] {1, null, 3, 2, 4, null, 5, 6});
    System.out.println(new Solution().postorder(root));
  }

  static class Solution {

    public List<Integer> postorder(Node root) {
      LinkedList<Integer> res = new LinkedList<>();
      if (root == null) return res;
      Deque<Node> stack = new ArrayDeque<>();
      stack.push(root);
      while (!stack.isEmpty()) {
        Node cur = stack.pop();
        res.addFirst(cur.val);
        for (Node child : cur.children) stack.push(child);
      }
      return res;
    }

    /**
     * Trivial recursion
     */
    public List<Integer> postorder2(Node root) {
      List<Integer> res = new ArrayList<>();
      recursive(root, res);
      return res;
    }

    private void recursive(Node node, List<Integer> res) {
      if (node == null) return;
      for (Node child: node.children) {
        recursive(child, res);
      }
      res.add(node.val);
    }
  }
}
