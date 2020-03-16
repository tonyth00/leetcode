import shared.Helper;
import shared.ListNode;

/**
 * Solution61
 */
public class Solution61 {

  public static void main(String[] args) {
    Helper.print(new Solution().rotateRight(Helper.createLinkedList(new int[] { 1, 2, 3, 4, 5, 6 }), 2));
  }

  static class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if (k == 0 || head == null || head.next == null)
        return head;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      int length = 0;
      ListNode fast = head;
      ListNode cur = head;
      while (fast != null) {
        length++;
        fast = fast.next;

      }

      k = k % length;
      if (k == 0) return dummy.next;

      fast = head;
      while (k > 0) {
        fast = fast.next;
        k--;
      }
      while (fast.next != null) {
        cur = cur.next;
        fast = fast.next;
      }
      fast.next = head;
      dummy.next = cur.next;
      cur.next = null;

      return dummy.next;
    }
  }
}