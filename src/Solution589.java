import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import shared.nary.Node;
import shared.Helper;

public class Solution589 {
  public static void main(String[] args) {
    Node root = Helper.createNaryTree(new Integer[] {1, null, 3, 2, 4, null, 5, 6});
    System.out.println(new Solution().preorder(root));
  }

  static class Solution {

    public List<Integer> preorder(Node root) {
      List<Integer> res = new ArrayList<>();
      if (root == null) return res;
      Deque<Node> stack = new ArrayDeque<>();
      stack.push(root);
      while (!stack.isEmpty()) {
        Node cur = stack.pop();
        res.add(cur.val);
        for (int i = cur.children.size() - 1; i >= 0; i--) stack.push(cur.children.get(i));
      }
      return res;
    }

    /**
     * Trivial recursion
     */
    public List<Integer> preorder2(Node root) {
      List<Integer> res = new ArrayList<>();
      recursive(root, res);
      return res;
    }

    private void recursive(Node node, List<Integer> res) {
      if (node == null) return;
      res.add(node.val);
      for (Node child: node.children) {
        recursive(child, res);
      }
    }
  }
}
