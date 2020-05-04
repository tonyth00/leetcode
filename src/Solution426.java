public class Solution426 {
  public static void main(String[] args) {

    Node root = new Node(4);
    root.right = new Node(5);
    root.left = new Node(2);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    System.out.println(new Solution().treeToDoublyList(root).val);
  }

  static class Solution {
    public Node treeToDoublyList(Node root) {
      Node[] res = straighten(root);
      if (res == null) return null;
      res[0].left = res[1];
      res[1].right = res[0];
      return res[0];
    }

    private Node[] straighten(Node node) {
      if (node == null) return null;

      Node[] left = straighten(node.left);
      Node[] right = straighten(node.right);

      
      if (left != null) {
        node.left = left[1];
        left[1].right = node;
      }
      if (right != null) {
        node.right = right[0];
        right[0].left = node;
      }

      return new Node[] { left == null ? node : left[0], right == null ? node: right[1] };
    }
  }

  static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  };
}
