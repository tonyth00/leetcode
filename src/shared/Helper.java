package shared;

import java.util.Deque;
import java.util.LinkedList;

public class Helper {
  public static void print(ListNode node) {
    while (node != null) {
      System.out.print(node.val + "->");
      node = node.next;
    }
    System.out.println("null");
  }

  public static void print(int[][] mat) {
    System.out.println('[');
    for (int i = 0; i < mat.length; i++) {
      System.out.print(" [");
      for (int j = 0; j < mat[0].length; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println("]");
    }
    System.out.println(']');
  }

  public static void print(char[][] mat) {
    System.out.println('[');
    for (int i = 0; i < mat.length; i++) {
      System.out.print(" [");
      for (int j = 0; j < mat[0].length; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println("]");
    }
    System.out.println(']');
  }

  public static void print(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
    }
    System.out.println("]");
  }

  public static void print(char[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
    }
    System.out.println("]");
  }

  public static void print(String[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
    }
    System.out.println("]");
  }

  public static void print(boolean[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
    }
    System.out.println("]");
  }

  public static void print(TreeNode node) {
    BTreePrinter.printNode(node);
  }

  public static ListNode createLinkedList(int[] arr) {
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    for (int i = 0; i < arr.length; i++) {
      dummy.next = new ListNode(arr[i]);
      dummy = dummy.next;
    }
    return head.next;
  }

  public static TreeNode generateTree(Integer[] nums) {
    Deque<TreeNode> nodes = new LinkedList<>();
    TreeNode root = nums[0] == null ? null : new TreeNode(nums[0]);
    if (root != null) nodes.add(root);
    int pos = 1;
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodes.remove();
        node.left = pos >= nums.length ? null : createNode(nums[pos++]);
        node.right = pos >= nums.length ? null : createNode(nums[pos++]);
        if (node.left != null) nodes.add(node.left);
        if (node.right != null) nodes.add(node.right);
      }
    }

    return root;
  }
  private static TreeNode createNode(Integer val) {
    if (val == null) return null;
    return new TreeNode(val);
  }

  
}