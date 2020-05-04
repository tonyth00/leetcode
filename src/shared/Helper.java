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
    int m = mat.length;
    int n = mat[0].length;
    int maxLen = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        maxLen = Math.max(maxLen, String.valueOf(mat[i][j]).length());
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append('[');

    for (int i = 0; i < m; i++) {
      sb.append(i == 0 ? '[' : " [");
      for (int j = 0; j < n; j++) {
        String entry = String.valueOf(mat[i][j]);
        while (entry.length() < maxLen) {
          entry += ' ';
        }

        sb.append(entry + (j == n - 1 ? "" : " "));
      }
      sb.append(']' + (i == m - 1 ? "" : "\n"));
    }
    sb.append(']');
    System.out.println(sb.toString());
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
      System.out.print("\"" + arr[i] + "\"" + (i == arr.length - 1 ? "" : ", "));
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

  public static TreeNode createTree(Integer[] nums) {
    if (nums.length == 0) return null;
    Deque<TreeNode> nodes = new LinkedList<>();
    TreeNode root = nums[0] == null ? null : new TreeNode(nums[0]);
    if (root != null)
      nodes.add(root);
    int pos = 1;
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = nodes.remove();
        node.left = pos >= nums.length ? null : createNode(nums[pos++]);
        node.right = pos >= nums.length ? null : createNode(nums[pos++]);
        if (node.left != null)
          nodes.add(node.left);
        if (node.right != null)
          nodes.add(node.right);
      }
    }

    return root;
  }

  private static TreeNode createNode(Integer val) {
    if (val == null)
      return null;
    return new TreeNode(val);
  }


}
