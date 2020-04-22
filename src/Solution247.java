import java.util.ArrayList;
import java.util.List;

public class Solution247 {
  public static void main(String[] args) {
    System.out.println(new Solution().findStrobogrammatic(1));
  }

  static class Solution {
    final char[][] map = {{'0','0'},{'1','1'},{'6','9'},{'8','8'},{'9','6'}};
    public List<String> findStrobogrammatic(int n) {
      char[] ch = new char[n];
      List<String> res = new ArrayList<>();
      helper(res, 0, n - 1, ch);
      return res;
    }

    private void helper(List<String> res, int start, int end, char[] ch) {
      if (start > end) {
        res.add(new String(ch));
        return;
      }

      for (char[] pair : map) {
        if (start == end && pair[0] != pair[1]) continue;
        if (start == 0 && ch.length > 1 && pair[0] == '0') continue;

        ch[start] = pair[0];
        ch[end] = pair[1];
        helper(res, start + 1, end - 1, ch);
      }

    }
  }
}