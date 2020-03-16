import shared.Helper;
import shared.ListNode;

/**
 * Solution24
 */
public class Solution24 {

  public static void main(String[] args) {
    Helper.print(new Solution().swapPairs(Helper.createLinkedList(new int[] { 1, 2, 3, 4 })));
  }

  static class Solution {
    public ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null)
        return head;
      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode prevPair = dummy;
      ListNode p1 = head;

      while (p1 != null) {
        ListNode p2 = p1.next;
        if (p2 == null) return dummy.next;
        ListNode next = p2.next;
        p2.next = p1;
        prevPair.next = p2;
        prevPair = p1;
        p1.next = next;
        p1 = next;
      }

      return dummy.next;
    }
  }
}