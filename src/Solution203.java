import shared.Helper;
import shared.ListNode;

/**
 * Solution203
 */
public class Solution203 {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    Helper.print(new Solution().removeElements(head, 4));
  }

  static class Solution {
    public ListNode removeElements(ListNode head, int val) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode curr = head;
      ListNode prev = dummy;
      while (curr != null) {
        if (curr.val == val) {
          prev.next = curr.next;
          curr = prev.next;
        } else {
          prev = curr;
          curr = curr.next;
        }
      }
      return dummy.next;
    }
  }
}