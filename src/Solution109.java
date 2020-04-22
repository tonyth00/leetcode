import shared.TreeNode;
import shared.ListNode;
import shared.Helper;
import java.util.*;
public class Solution109 {
  public static void main(String[] args) {
    ListNode head = Helper.createLinkedList(new int[] {-10, -3, 0, 5, 9});
    Helper.print(new Solution().sortedListToBST(head));
  }

  static class Solution {
    public TreeNode sortedListToBST(ListNode head) {
      List<Integer> list = new ArrayList<>();
      while (head != null) {
        list.add(head.val);
        head = head.next;
      }
      return helper(list, 0, list.size() - 1);
    }

    private TreeNode helper(List<Integer> list, int L, int R) {
      if (L > R) return null;

      int M = L + (R - L)/2;
      TreeNode root = new TreeNode(list.get(M));
      root.left = helper(list, L, M - 1);
      root.right = helper(list, M + 1, R);
      return root;
    }
  }
}