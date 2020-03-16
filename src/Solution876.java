import shared.Helper;
import shared.ListNode;

/**
 * Solution876
 */
public class Solution876 {

  public static void main(String[] args) {
    Helper.print(new Solution().middleNode(Helper.createLinkedList(new int[] { 1, 2, 3, 4, 5 })));
  }

  static class Solution {
    public ListNode middleNode(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
    }
  }
}