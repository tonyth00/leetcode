import shared.Helper;
import shared.ListNode;

/**
 * Solution234
 */
public class Solution234 {

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome(Helper.createLinkedList(new int[] {1, 1, 2, 1})));
  }

  static class Solution {
    public boolean isPalindrome(ListNode head) {
      if (head == null || head.next == null) return true;

      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode slow = dummy;
      ListNode fast = dummy;

      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      ListNode cur = slow.next;
      ListNode prev = null;
      while (cur != null) {
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
      }
      
      ListNode l1 = dummy.next;
      ListNode l2 = prev;

      while (l2 != null) {
        if (l1.val != l2.val) return false;
        l1 = l1.next;
        l2 = l2.next;
      }

      return true;
    }
  }
}