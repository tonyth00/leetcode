import shared.TreeNode;
import shared.Helper;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution449 {
  public static void main(String[] args) {
    Codec codec = new Codec();
    TreeNode root = Helper.createTree(new Integer[] {6, 3, 9, 4});

    String s = codec.serialize(root);
    System.out.println(s);
    Helper.print(codec.deserialize(s));
  }

  static class Codec {

    // 3 2 6 4 7

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      serial(root, sb);
      return sb.toString();
    }

    private void serial(TreeNode node, StringBuilder sb) {
      if (node == null) return;
      if (sb.length() > 0) sb.append(',');
      sb.append(node.val);
      serial(node.left, sb);
      serial(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data.isEmpty()) return null;
      Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
      return deserial(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode deserial(Deque<String> queue, int min, int max) {
      if (queue.isEmpty()) return null;
      int val = Integer.parseInt(queue.peek());
      if (val < min || val > max) return null;
      queue.remove();
      TreeNode node = new TreeNode(val);
      
      node.left = deserial(queue, min, node.val);
      node.right = deserial(queue, node.val, max);
      return node;
    }
  }
}
