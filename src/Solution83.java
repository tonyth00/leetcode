import shared.Helper;
import shared.ListNode;

/**
 * Solution83
 */
public class Solution83 {

  public static void main(String[] args) {

    Helper.print(new Solution().deleteDuplicates(Helper.createLinkedList(new int[] { 1, 1, 2 })));
  }

  static class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      if (head == null || head.next == null)
        return head;

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode cur = head;
      while (cur != null) {
        ListNode next = cur.next;
        while (next != null && next.val == cur.val) {
          next = next.next;
        }
        cur.next = next;
        cur = next;
      }
      
      return dummy.next;
    }
  }
}