public class Solution117 {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(5);
    root.right.right = new Node(7);

    new Solution().connect(root);

  }

  static class Solution {

    /**
     * Intuition:
     * Similar linked list stitching process as Solution116.java
     * Only difference now is the binary tree isn't perfect. At
     * every new level keep a prev node that links to a new node
     * everytime it sees one. At the beginning, it points to dummy.
     * When we finish a level, dummy.next will point to the next level's
     * leftmost node, so leftMost = dummy.next.
     * Note: Always think of using a dummy node whenever we're doing 
     * a ton of null checks in LinkedList type questions.
     * 
     * O(n) time
     * O(1) space
     * 
     */
    public Node connect(Node root) {
      Node leftMost = root;
      Node dummy = new Node(0);
      while (leftMost != null) {
        Node cur = leftMost;
        Node prev = dummy;
        while (cur != null) {
          if (cur.left != null) {
            prev.next = cur.left;
            prev = prev.next;
          }
          
          if (cur.right != null) {
            prev.next = cur.right;
            prev = prev.next;
          }

          cur = cur.next;
        }
        leftMost = dummy.next; // dummy.next points to leftMost node on the next level.
        dummy.next = null; // clear dummy for next level
      }
      return root;
    }
  }

  static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };
}
