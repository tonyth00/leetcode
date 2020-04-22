import java.util.HashSet;
import java.util.Set;
import shared.Helper;
import shared.ListNode;

public class Solution817 {
  public static void main(String[] args) {
    ListNode head = Helper.createLinkedList(new int[] {0, 1, 2, 3, 4});
    System.out.println(new Solution().numComponents(head, new int[] {0, 3, 1, 4}));
  }

  static class Solution {
    public int numComponents(ListNode head, int[] G) {
      Set<Integer> set = new HashSet<>();
      for (int num : G) set.add(num);

      int sum = 0;
      while (head != null) {
        if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) sum++;
        head = head.next;
      }

      return sum;
    }
  }
}
