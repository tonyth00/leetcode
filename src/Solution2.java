import shared.Helper;
import shared.ListNode;

public class Solution2 {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    Helper.print(new Solution().addTwoNumbers(l1, l2));
  }

  static class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int carry = 0;
      ListNode head = new ListNode(0);
      ListNode current = head;

      while (l1 != null || l2 != null) {
        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
        carry = 0;
        if (sum >= 10) {
          sum -= 10;
          carry = 1;
        }

        current.next = new ListNode(sum);

        current = current.next;

        if (l1 != null)
          l1 = l1.next;
        if (l2 != null)
          l2 = l2.next;
      }

      if (carry > 0) {
        current.next = new ListNode(carry);
      }

      return head.next;

    }
  }
}