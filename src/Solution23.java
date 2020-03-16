import java.util.HashSet;
import java.util.Set;

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
      ListNode current = dummy;

      Set<Integer> activeListIndices = new HashSet<>();
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          activeListIndices.add(i);
        }
      }

      while (!activeListIndices.isEmpty()) {
        if (activeListIndices.size() == 1) {
          current.next = lists[activeListIndices.toArray(new Integer[1])[0]];
          return dummy.next;
        }
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = -1;
        for (Integer index : activeListIndices) {
          ListNode node = lists[index];
          if (node.val < minValue) {
            minValue = node.val;
            minValueIndex = index;
          }
        }
        current.next = lists[minValueIndex];
        current = current.next;
        lists[minValueIndex] = lists[minValueIndex].next;
        if (lists[minValueIndex] == null) {
          activeListIndices.remove(minValueIndex);
        }
      }

      return dummy.next;

    }
  }
}