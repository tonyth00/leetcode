import shared.Helper;
import shared.ListNode;

/**
 * Solution143
 */
public class Solution143 {

  public static void main(String[] args) {
    ListNode head = Helper.createLinkedList(new int[] { 1, 2, 3, 4, 5 });
    new Solution().reorderList(head);
    Helper.print(head);
  }

  static class Solution {
    public void reorderList(ListNode head) {
      if (head == null || head.next == null || head.next.next == null)
        return;

      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode left = dummy;
      ListNode right = dummy;
      while (right != null && right.next != null) {
        left = left.next;
        right = right.next.next;
      }

      right = left.next;
      left.next = null;
      left = head;
      
      right = reverse(right);

      while (right != null) {
        ListNode temp = left.next;
        left.next = right;
        left = temp;
        temp = right.next;
        right.next = left;
        right = temp;
      }
    }

    public ListNode reverse(ListNode node) {
      ListNode prev = null;
      ListNode cur = node;
      while (cur != null) {
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
      }

      return prev;

    }
  }
}