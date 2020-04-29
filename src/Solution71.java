import java.util.Deque;
import java.util.ArrayDeque;

public class Solution71 {
  public static void main(String[] args) {
    System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
  }

  static class Solution {
    public String simplifyPath(String path) {
      Deque<String> queue = new ArrayDeque<>();
      int start = 0;
      for (int end = 0; end <= path.length(); end++) {
        if (end < path.length() && path.charAt(end) != '/') continue;
        if (start == end) continue;
        String sub = path.substring(start + 1, end);
        if (sub.equals("")) {
        } else if (sub.equals("..")) {
          if (!queue.isEmpty()) queue.removeLast();
        } else if (sub.equals(".")) {
        } else {
          queue.addLast(sub);
        }
        start = end;
      }

      StringBuilder sb = new StringBuilder("/");
      while (!queue.isEmpty()) {
        sb.append(queue.removeFirst());
        if (!queue.isEmpty())
          sb.append("/");
      }
      return sb.toString();
    }
  }
}
