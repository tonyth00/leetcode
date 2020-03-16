import shared.Helper;
import shared.ListNode;

/**
 * Solution86
 */
public class Solution86 {

  public static void main(String[] args) {
    Helper.print(new Solution().partition(Helper.createLinkedList(new int[] { 1, 4, 3, 2, 5, 2 }), 3));
  }

  static class Solution {
    public ListNode partition(ListNode head, int x) {
      if (head == null || head.next == null) return head;
      ListNode l1 = new ListNode(0), l2 = l1;
      ListNode r1 = new ListNode(0), r2 = r1;

      ListNode cur = head;
      while (cur != null) {
        if (cur.val < x) {
          l2.next = cur;
          cur = cur.next;
          l2 = l2.next;
        } else {
          r2.next = cur;
          cur = cur.next;
          r2 = r2.next;
        }
      }
      l2.next = r1.next;
      r2.next = null;

      return l1.next;

    }
  }
}