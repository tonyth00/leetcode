import shared.Helper;
import shared.ListNode;

/**
 * Solution160
 */
public class Solution160 {

  public static void main(String[] args) {
    ListNode headA = Helper.createLinkedList(new int[] { 4, 1, 8, 4, 5 });
    ListNode headB = Helper.createLinkedList(new int[] { 5, 0, 1 });
    headB.next.next.next = headA.next.next;
    System.out.println(new Solution().getIntersectionNode(headA, headB).val);
  }

  static class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) return null;

      ListNode curA = headA;
      ListNode curB = headB;
      while (curA != curB) {
        curA = curA == null ? headB : curA.next;
        curB = curB == null ? headA : curB.next;
      }
      return curA;
    }
  }
}