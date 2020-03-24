package shared;

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

  public static void print(int[] arr) {
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
    TreeNode[] nodes = new TreeNode[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != null) {
        nodes[i] = new TreeNode(nums[i]);

        if (i > 0) {
          if (i % 2 == 0) {
            nodes[(i - 1) / 2].right = nodes[i];
          } else {
            nodes[(i - 1) / 2].left = nodes[i];
          }
        }
      }
    }

    return nodes[0];
  }

  
}