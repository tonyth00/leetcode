import java.util.Deque;
import java.util.LinkedList;

import shared.list.Node;
/**
 * Solution430
 */
public class Solution430 {

  public static void main(String[] args) {
    Node head1 = Node.createNodes(new int[] {1, 2, 3, 4, 5, 6});
    Node head2 = Node.createNodes(new int[] {7, 8, 9, 10});
    Node head3 = Node.createNodes(new int[] {11, 12});
    head1.next.next.child = head2;
    head2.next.child = head3;
    Node.print(new Solution().flatten(head1));
  }
  static class Solution {
    public Node flatten(Node head) {
      Node cur = head;

      Deque<Node> stack = new LinkedList<>();
      while (cur != null) {
        if (cur.child != null) {
          if (cur.next != null) stack.push(cur.next);
          cur.next = cur.child;
          cur.child = null;
        } else if (cur.next == null && !stack.isEmpty()) {
          cur.next = stack.pop();
        }
        if (cur.next != null) cur.next.prev = cur;
        cur = cur.next;
      }
      return head;
    }
  }
}