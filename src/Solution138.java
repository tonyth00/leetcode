import java.util.Map;
import java.util.HashMap;
public class Solution138 {
  public static void main(String[] args) {

  }

  static class Solution {
    public Node copyRandomList(Node head) {
      Node cur = head;
      while (cur != null) {
        Node copyNode = new Node(cur.val);
        copyNode.next = cur.next;
        cur.next = copyNode;
        cur = cur.next.next;
      }

      cur = head;
      while (cur != null) {
        Node copyNode = cur.next;
        copyNode.random = cur.random == null ? null : cur.random.next;
        cur = cur.next.next;
      }
      
      cur = head;
      Node dummy = new Node(-1);
      Node copyNode = dummy;
      while (cur != null) {
        copyNode.next = cur.next;
        copyNode = copyNode.next;
        cur.next = copyNode.next;
        cur = cur.next;
      }

      return dummy.next;
    }

    
    public Node copyRandomList2(Node head) {
      Map<Node, Node> map = new HashMap<>();
      
      Node cur = head;
      while (cur != null) {
        map.put(cur, new Node(cur.val));
        cur = cur.next;
      }
      cur = head;
      while (cur != null) {
        Node copyNode = map.get(cur);
        copyNode.next = map.get(cur.next);
        copyNode.random = map.get(cur.random);
        cur = cur.next;
      }

      return map.get(head);
    }
  }

  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
