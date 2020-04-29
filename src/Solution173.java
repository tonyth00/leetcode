import shared.TreeNode;
import shared.Helper;
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution173 {
  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] {7, 3, 15, null, null, 9, 20});
    BSTIterator iterator = new BSTIterator(root);
    System.out.println(iterator.next()); // return 3
    System.out.println(iterator.next()); // return 7
    System.out.println(iterator.hasNext()); // return true
    System.out.println(iterator.next()); // return 9
    System.out.println(iterator.hasNext()); // return true
    System.out.println(iterator.next()); // return 15
    System.out.println(iterator.hasNext()); // return true
    System.out.println(iterator.next()); // return 20
    System.out.println(iterator.hasNext()); // return false
  }

  /**
   * Intuition:
   * We want to always keep track of the minimum element in the BST, which is the farthest left node.
   * To iterate through a BST is to perform in-order traversal on it. How can we do this iteratively?
   * Use a stack that stores the minimum element at the top. Whenever a next element is requested:
   * - Pop off the node => min. Top of stack now contains next minimum we've seen so far.
   * - If min's right is not null, there are nodes smaller than what we've seen so far, explore that subtree.
   */
  static class BSTIterator {
    Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
    }

    /** @return the next smallest number */
    public int next() {
      TreeNode node = stack.pop();
      if (node.right != null) {
        TreeNode temp = node.right;
        while (temp != null) {
          stack.push(temp);
          temp = temp.left;
        }
      }
      return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return !stack.isEmpty();
    }
  }
}
