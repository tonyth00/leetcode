import shared.Helper;
import shared.ListNode;

/**
 * Solution141
 */
public class Solution141 {

  public static void main(String[] args) {

    ListNode head = Helper.createLinkedList(new int[] { 1, 2, 3, 4, 5 });
    ListNode tail = head.next.next.next.next;
    tail.next = head.next.next;
    
    System.out.println(new Solution().hasCycle(head));
  }

  static public class Solution {
    public boolean hasCycle(ListNode head) {
      if (head == null) return false;
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
      }

      return false;

    }
  }
}