package shared.list;

public class Node {
  public int val;
  public Node prev;
  public Node next;
  public Node child;
  public Node(int val) {
    this.val = val;
  }

  public static Node createNodes(int[] arr) {
    Node dummy = new Node(0);
    Node cur = dummy;
    int i = 0;
    while (i < arr.length) {
      cur.next = new Node(arr[i]);
      cur = cur.next;
      i++;
    }
    return dummy.next;
  }

  public static void print(Node head) {
    StringBuilder sb = new StringBuilder();
    Node cur = head;
    while (cur != null) {
      sb.append(cur.val).append("->");
      cur = cur.next;
    }
    sb.append("null");
    System.out.println(sb.toString());
  }
};