import shared.ListNode;
import shared.Helper;

public class Solution148 {
  public static void main(String[] args) {
    ListNode head = Helper.createLinkedList(new int[] {8, 2, 5, 4, 7, 3, -1});
    Helper.print(new Solution().sortList(head));
  }

  static class Solution {
    public ListNode sortList(ListNode head) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;

      int n = 0;
      while (head != null) {
        n++;
        head = head.next;
      }

      for (int size = 1; size < n; size <<= 1) {
        ListNode prev = dummy;
        while (prev.next != null) {
          ListNode l1 = prev.next;
          ListNode l2 = split(l1, size);
          ListNode next = split(l2, size);
          
          ListNode[] res = merge(l1, l2);
          prev.next = res[0];
          if (res[1] != null) res[1].next = next;
          prev = res[1];
        }  
      }
      return dummy.next;
    }

    private ListNode[] merge(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode temp = dummy;
      while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          temp.next = l1;
          l1 = l1.next;
        } else {
          temp.next = l2;
          l2 = l2.next;
        }
        temp = temp.next;
      }
      
      temp.next = l1 != null ? l1 : l2;
      while (temp.next != null) {
        temp = temp.next;
      }
      return new ListNode[] {dummy.next, temp};
    }

    private ListNode split(ListNode node, int size) {
      while (node != null && size > 1) {
        node = node.next;
        size--;
      }

      if (node == null) {
        return null;
      } else {
        ListNode temp = node.next;
        node.next = null;
        return temp;
      }
    }
  }
}
