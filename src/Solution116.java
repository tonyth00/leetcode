import java.util.Deque;
import java.util.ArrayDeque;

public class Solution116 {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    new Solution().connect(root);
  }

  static class Solution {

    /**
     * Intuition:
     * Perform the "localized" recursive procedure iteratively, level by level.
     * Process level L + 1 at level L.
     * 
     * Consider that we're on level L.
     * - leftMost points to the leftmost node on every level
     * - cur starts at leftMost and iterates like a linkedlist towards the right, stitching
     * a linkedlist at level L + 1.
     * - when cur reaches the end of the current level, leftMost = leftMost.left and we repeat
     * the process.
     * 
     * O(n) time, O(1) space
     */
    public Node connect(Node root) {
      Node leftMost = root;
      while (leftMost != null) {
        Node cur = leftMost;
        while (cur != null) {
          if (cur.left != null) cur.left.next = cur.right;
          if (cur.left != null && cur.next != null) cur.right.next = cur.next.left;
          cur = cur.next;
        }

        leftMost = leftMost.left;
      }
      return root;
    }

    /**
     * Invariant: Binary tree is perfect. A node containing a left child will also have right child.
     * Intuition: DFS process current node. Process level L + 1 at level L.
     * 1.) If node is null or node doesn't have left child, there's nothing to process. Return
     * 2.) Connect left child to right child
     * 3.) If current node has right neighbour, connect right child to neighbour's left child.
     * 
     * O(n) time
     * O(log n) space due to implicit stack 
     */
    public Node connect3(Node node) {
      if (node == null || node.left == null) return node;
      node.left.next = node.right;
      if (node.next != null) node.right.next = node.next.left;
      connect(node.left);
      connect(node.right);
      return node;
    }

    /**
     * Intuition: Trivial BFS
     * O(n) time
     * O(n)/O(2^h) space
     */
    public Node connect2(Node root) {
      if (root == null) return root;
      Deque<Node> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        Node prev = null;
        for (int i = 0; i < size; i++) {
          Node cur = queue.remove();
          if (cur.left != null) queue.add(cur.left);
          if (cur.right != null) queue.add(cur.right);

          if (prev != null) prev.next = cur;
          prev = cur;
        }
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
