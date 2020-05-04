import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
public class Solution428 {
  public static void main(String[] args) {
    Node[] children = { new Node(3, new ArrayList<>()), new Node(2, new ArrayList<>()), new Node(4, new ArrayList<>()) };
    children[0].children.add(new Node(5, new ArrayList<>()));
    children[0].children.add(new Node(6, new ArrayList<>()));

    Node root = new Node(1, Arrays.asList(children));

    System.out.println(new Codec().serialize(root));
  }

  static class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
      StringBuilder sb = new StringBuilder();
      serialize(root, sb);
      return sb.toString();
    }

    private void serialize(Node node, StringBuilder sb) {
      if (node == null) return;
      sb.append(node.val).append(',').append(node.children.size()).append(',');
      for (Node n : node.children) serialize(n, sb);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
      if (data.isEmpty()) return null;
      Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
      
      return deserialize(queue);

    }

    private Node deserialize(Queue<String> queue) {
      int val = Integer.parseInt(queue.remove());
      int size = Integer.parseInt(queue.remove());

      Node node = new Node(val, new ArrayList<>(size));
      for (int i = 0; i < size; i++) {
        node.children.add(deserialize(queue));
      }
      return node;
    }
  }

  static class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
}
