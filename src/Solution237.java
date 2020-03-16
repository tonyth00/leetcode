import shared.Helper;
import shared.ListNode;

/**
 * Solution237
 */
public class Solution237 {

  public static void main(String[] args) {
    ListNode node = new ListNode(4);
    node.next = new ListNode(5);
    node.next.next = new ListNode(1);
    node.next.next.next = new ListNode(9);

    new Solution().deleteNode(node.next);
    Helper.print(node);
  }

  static class Solution {
    public void deleteNode(ListNode node) {
      while (node.next != null) {
        node.val = node.next.val;
        if (node.next.next == null) {
          node.next = null;
          break;
        }
        node = node.next;
      }
    }
  }
}