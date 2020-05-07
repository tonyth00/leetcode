import java.util.*;
import shared.TreeNode;
import shared.Helper;
public class Solution272 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {4, 2, 5, 1, 3});
    System.out.println(new Solution().closestKValues(root, 3.714286, 2));
  }

  static class Solution {
    /**
     * Balanced tree: O(log n + k) time
     * Unbalanced tree: O(n + k) time
     * 
     * O(log n) space since each stack stores at most O(log n) elements.
     * 
     * Intuition:
     * Have two stacks:
     * - "big" stores all values larger than target, with next closest on top.
     * - "small" stores all values smaller than target, with next closest on top.
     * 
     * 1). From the root, iterate down from root to leaf. If the value is larger, 
     * than the target, push to "big", otherwise push to "small". The direction downstream
     * is dependent on the node's value, the general idea is we want to get closer 
     * to the target. That way, the stacks are correctly filled with nodes increasingly 
     * closer to the target.
     * 
     * So if node.val > target, go left, and otherwise go right.
     * 
     * 2). Now that we have the closest smaller and larger elements from target, we pluck
     * the closer one, add to result, and update the stack. For example, if we pluck from
     * "big", the next largest value is in the right subtree (by definition of BST). In particular,
     * it's the farthest left node from plucked node's right subtree. So we need to update the stack
     * to store all nodes along the path to the next largest value. This has O(1) amortized time.
     * We perform this k times, so O(k) time.
     * 
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
      Deque<TreeNode> small = new ArrayDeque<>();
      Deque<TreeNode> big = new ArrayDeque<>();

      // O(log n)
      TreeNode cur = root;
      while (cur != null) {
        if (cur.val < target) {
          small.push(cur);
          cur = cur.right;
        } else {
          big.push(cur);
          cur = cur.left;
        }
      }

      List<Integer> res = new ArrayList<>();

      // O(k) amortized time.
      while (k > 0) {
        if (big.isEmpty() || !small.isEmpty() && big.peek().val - target > target - small.peek().val) {
          TreeNode node = small.pop();
          res.add(node.val);
          
          node = node.left;
          while(node != null) {
            small.push(node);
            node = node.right;
          }
        } else {
          TreeNode node = big.pop();
          res.add(node.val);

          node = node.right;
          while (node != null) {
            big.push(node);
            node = node.left;
          }
        }

        k--;
      }

      return res;

    }

    /**
     * Priority queue - less space but more time.
     * 
     * O(n log k) time
     * O(k) space
     */
    public List<Integer> closestKValues3(TreeNode root, double target, int k) {
      Queue<Integer> queue = new PriorityQueue<>((a, b) -> Double.compare(Math.abs(b - target), Math.abs(a - target)));
      dfs(root, queue, k);
      return new ArrayList<>(queue);
    }

    private void dfs(TreeNode node, Queue<Integer> queue, int k) {
      if (node == null) return;
      queue.add(node.val);
      if (queue.size() > k) queue.remove();

      dfs(node.left, queue, k);
      dfs(node.right, queue, k);
    }


    /**
     * Brute force
     * O(n) time and space
     */
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
      LinkedList<Integer> nums = new LinkedList<>();
      inorder(root, nums);

      while (nums.size() > k) {
        if (Math.abs(nums.peekFirst() - target) < Math.abs(nums.peekLast() - target)) nums.removeLast();
        else nums.removeFirst();
      }

      return nums;
    }

    private void inorder(TreeNode node, LinkedList<Integer> nums) {
      if (node == null) return;
      inorder(node.left, nums);
      nums.add(node.val);
      inorder(node.right, nums);
    }
  }
}
