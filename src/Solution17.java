import java.util.*;

class Solution17 {
  public static void main(String[] args) {
    System.out.println(new Solution().letterCombinations("23"));
  }

  static class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> res = new ArrayList<>();
      if (digits.length() == 0) return res;
      String[] map = { null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      StringBuilder sb = new StringBuilder();
      helper(digits, map, sb, res, 0);
      return res;
    }

    private void helper(String digits, String[] map, StringBuilder sb, List<String> res, int index) {
      if (index == digits.length()) {
        res.add(sb.toString());
        return;
      }

      int num = digits.charAt(index) - '0';
      String str = map[num];
      for (int i = 0; i < str.length(); i++) {
        sb.append(str.charAt(i));
        helper(digits, map, sb, res, index + 1);
        sb.setLength(sb.length() - 1);
      }
    }
  }
}