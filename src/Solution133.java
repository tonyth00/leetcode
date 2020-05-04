import shared.graph.Node;
import java.util.Map;
import java.util.HashMap;

class Solution133 {
  public static void main(String[] args) {
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    a.neighbors.add(b);
    a.neighbors.add(d);
    b.neighbors.add(a);
    b.neighbors.add(c);
    c.neighbors.add(b);
    c.neighbors.add(d);
    d.neighbors.add(a);
    d.neighbors.add(c);

    new Solution().cloneGraph(a);
  }

  static class Solution {
    public Node cloneGraph(Node node) {
      if (node == null) return null;
      Map<Integer, Node> map = new HashMap<>();

      return helper(node, map);
    }

    private Node helper(Node node, Map<Integer, Node> map) {
      if (map.containsKey(node.val)) return map.get(node.val);
      Node clone = new Node(node.val);
      map.put(node.val, clone);
      
      for (Node neighbor : node.neighbors) {
        clone.neighbors.add(helper(neighbor, map));
      } 

      return clone;
    }
  }
}