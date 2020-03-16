import shared.Helper;
import shared.ListNode;

/**
 * Solution92
 */
public class Solution92 {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    Helper.print(new Solution().reverseBetween(head, 1, 5));
  }

  static class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      if (m == n) return head;

      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode leftA = dummy;
      for (int i = 0 ; i < m - 1; i++) {
        leftA = leftA.next;
      }

      ListNode leftB = leftA.next;
      ListNode curr = leftB;
      int count = n - m;
      ListNode prev = null;
      while (count > 0) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        count--;
      }
      
      ListNode rightB = curr.next;
      ListNode rightA = curr;
      curr.next = prev;

      leftA.next = rightA;
      leftB.next = rightB;
      return dummy.next;
    }
  }
}