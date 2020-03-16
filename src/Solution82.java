import shared.Helper;
import shared.ListNode;

/**
 * Solution82
 */
public class Solution82 {

  public static void main(String[] args) {
    Helper.print(new Solution().deleteDuplicates(Helper.createLinkedList(new int[] { 1, 1, 1, 2, 3 })));
  }

  static class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      if (head == null || head.next == null)
        return head;
      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode prevSolo = dummy;

      ListNode cur = head;
      while (cur != null) {
        if (cur.next == null) {
          break;
        } else if (cur.next.val == cur.val) {
          while (cur.next != null && cur.val == cur.next.val) {
            cur = cur.next;
          }
          prevSolo.next = cur.next;
        } else if (cur.next.val != cur.val) {
          prevSolo.next = cur;
          prevSolo = cur;

        }
        cur = cur.next;
      }

      return dummy.next;
    }
  }
}