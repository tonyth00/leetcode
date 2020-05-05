import shared.nary.Node;
import java.util.List;
import java.util.ArrayList;

public class Solution559 {
  public static void main(String[] args) {
    List<Node> children = new ArrayList<>();

    Node child = new Node(3, new ArrayList<>());
    child.children.add(new Node(5));
    child.children.add(new Node(6));

    children.add(child);
    children.add(new Node(2));
    children.add(new Node(4));

    Node root = new Node(1, children);
    System.out.println(new Solution().maxDepth(root));
  }

  static class Solution {
    public int maxDepth(Node node) {
      if (node == null) return 0;
      if (node.children == null || node.children.size() == 0) return 0;

      int max = Integer.MIN_VALUE;
      for (Node child : node.children) {
        max = Math.max(max, maxDepth(child));
      }

      return 1 + max;
    }
  }
}
