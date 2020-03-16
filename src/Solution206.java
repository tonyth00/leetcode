import shared.Helper;
import shared.ListNode;

/**
 * Solution206
 */
public class Solution206 {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    Helper.print(new Solution().reverseList(head));
  }

  static class Solution {
    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) return head;

      ListNode prev = null;
      ListNode curr = head;
      while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
      }

      return prev;
    }
  }
}