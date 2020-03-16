import shared.Helper;
import shared.ListNode;

/**
 * Solution19
 */
public class Solution19 {

  public static void main(String[] args) {
    ListNode head = Helper.createLinkedList(new int[] { 1, 2, 3, 4, 5 });
    Helper.print(new Solution().removeNthFromEnd(head, 2));

  }

  static class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode p1 = new ListNode(0);
      p1.next = head;
      ListNode p2 = p1;
      head = p1;
      for (int i = 0; i < n; i++) {
        p2 = p2.next;
      }

      while (p2.next != null) {
        p1 = p1.next;
        p2 = p2.next;
      }

      p1.next = p1.next.next;
      return head.next;
    }
  }
}