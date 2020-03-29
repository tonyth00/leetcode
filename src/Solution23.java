import java.util.PriorityQueue;

import shared.Helper;
import shared.ListNode;

/**
 * Solution23
 */
public class Solution23 {

  public static void main(String[] args) {
    ListNode[] lists = new ListNode[3];
    lists[0] = Helper.createLinkedList(new int[] {1, 4, 5});
    lists[1] = Helper.createLinkedList(new int[] {1, 3, 4});
    lists[2] = Helper.createLinkedList(new int[] {2, 6});

    Helper.print(new Solution().mergeKLists(lists));
  }

  static class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      ListNode dummy = new ListNode(0);
      
      PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
      for (ListNode node : lists) {
        if (node != null) queue.add(node); // O(k log k)
      }

      ListNode cur = dummy;
      while (!queue.isEmpty()) { // runs O(nk) times, where n is average length of list
        ListNode node = queue.remove(); // O(log k)
        cur.next = node;
        cur = node;
        if (node.next != null) queue.add(node.next); // O(log k)

      }

      return dummy.next;
    }
  }
}