import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;


import shared.Helper;
import shared.TreeNode;

/**
 * Solution297
 */
public class Solution297 {

  public static void main(String[] args) {
    TreeNode root = Helper.createTree(new Integer[] { 1, 2, 3, null, null, 4, 5 });
    Codec codec = new Codec();
    System.out.println(codec.serialize(root));
    Helper.print(codec.deserialize(codec.serialize(root)));
  }

  static public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      serial(root, sb);
      return sb.toString();
    }

    private void serial(TreeNode node, StringBuilder sb) {
      if (node == null) sb.append('#');
      else {
        sb.append(node.val);
        sb.append(',');
        serial(node.left, sb);
        sb.append(',');
        serial(node.right, sb);
      }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
      return deserial(queue);
    }

    private TreeNode deserial(Deque<String> queue) {
      String s = queue.remove();
      if (s.equals("#")) return null;
      TreeNode node = new TreeNode(Integer.valueOf(s));
      node.left = deserial(queue);
      node.right = deserial(queue);
      return node;
    }
  }
}