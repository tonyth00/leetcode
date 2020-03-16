import shared.Helper;
import shared.ListNode;

/**
 * Solution25
 */
public class Solution25 {

  public static void main(String[] args) {
    Helper.print(new Solution().reverseKGroup(Helper.createLinkedList(new int[] { 1, 2 }), 2));
  }

  static class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      if (k <= 1 || head == null || head.next == null)
        return head;
      ListNode dummy = new ListNode(0);
      ListNode prevEnd = dummy;
      dummy.next = head;

      ListNode curr = dummy.next;
      ListNode nextCurr = curr;
      while (nextCurr != null) {
        prevEnd.next = curr;
        ListNode end = curr;
        // System.out.println("end " + end.val);

        for (int i = 0; i < k; i++) {
          nextCurr = nextCurr.next;
          if (nextCurr == null && i < k - 1) {
            return dummy.next;
          }
        }

        ListNode prev = null;
        while (curr != nextCurr) {
          ListNode next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
        }
        ListNode start = prev;
        prevEnd.next = start;
        prevEnd = end;
        // System.out.println("prevEnd " + prevEnd.val);
      }

      return dummy.next;
    }
  }
}