import java.util.*;
class Solution293 {
  public static void main(String[] args) {
    System.out.println(new Solution().generatePossibleNextMoves("++++"));
  }

  static class Solution {
    public List<String> generatePossibleNextMoves(String s) {
      List<String> res = new ArrayList<>();
      if (s == null) return res;

      char[] chs = s.toCharArray();
      for (int i = 0; i < s.length() - 1; i++) {
        if (chs[i] == '+' && chs[i+1] == '+') {
          chs[i] = chs[i+1] = '-';
          res.add(new String(chs));
          chs[i] = chs[i+1] = '+';
        }
      }
      return res;
    }
  }
}