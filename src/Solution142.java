import shared.Helper;
import shared.ListNode;

/**
 * Solution142
 */
public class Solution142 {

  public static void main(String[] args) {
    ListNode head = Helper.createLinkedList(new int[] { 3, 2, 0, 4 });
    ListNode tail = head.next.next.next;
    tail.next = head.next;
    System.out.println(new Solution().detectCycle(head).val);
  }

  static public class Solution {
    public ListNode detectCycle(ListNode head) {
      if (head == null)
        return head;

      ListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
          ListNode slow2 = head;
          while (slow != slow2) {
            slow2 = slow2.next;
            slow = slow.next;
          }
          return slow;
        }
      }
      return null;
    }
  }
}