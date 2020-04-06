
public class Solution1265 {
  public static void main(String[] args) {
    ImmutableListNode head = new ImmutableListNode(1);
    head.setNext(new ImmutableListNode(2));
    head.getNext().setNext(new ImmutableListNode(3));
    head.getNext().getNext().setNext(new ImmutableListNode(4));
    new Solution().printLinkedListInReverse(head);
  }
  
  static class Solution {
    public void printLinkedListInReverse(ImmutableListNode node) {
      if (node == null) return;

      printLinkedListInReverse(node.getNext());
      node.printValue();
    }
  }

  static class ImmutableListNode {
    private int val = -1;
    private ImmutableListNode next = null;
    public ImmutableListNode(int val) {
      this.val = val;
    }

    public void setNext(ImmutableListNode next) {
      this.next = next;
    }

    public ImmutableListNode getNext() {
      return next;
    }

    public void printValue() {
      System.out.print(val + " ");
    }
  }

}