import shared.*;
class Solution21 {
  public static void main(String[] args) {
    Helper.print(new Solution().mergeTwoLists(Helper.createLinkedList(new int[] {1, 2, 4}), Helper.createLinkedList(new int[] {1, 3, 4})));
  }

  static class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }
  }
}