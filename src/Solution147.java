import shared.ListNode;
import shared.Helper;
public class Solution147 {
  public static void main(String[] args) {
    ListNode head = Helper.createLinkedList(new int[] {1, 5, 3, 4, 0});
    Helper.print(new Solution().insertionSortList(head));
  }

  static class Solution {
    public ListNode insertionSortList(ListNode head) {
      if (head == null) return head;
      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode tail = head;
      ListNode next = tail.next;
      while (next != null) {
        if (next.val >= tail.val) {
          tail = next;
          next = tail.next;
        } else {
          tail.next = next.next;
          ListNode slow = dummy;
          ListNode fast = slow.next;
          while (fast.val <= next.val) {
            slow = fast;
            fast = slow.next;
          }
          slow.next = next;
          next.next = fast;
          next = tail.next;
        }
      }
      return dummy.next;
    }
  }
}
