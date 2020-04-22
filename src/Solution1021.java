
public class Solution1021 {
  public static void main(String[] args) {
    System.out.println(new Solution().removeOuterParentheses("(()())(())"));
  }

  static class Solution {
    public String removeOuterParentheses(String S) {
      StringBuilder sb = new StringBuilder();
      int count = 0;
      for (char c : S.toCharArray()) {
        if (c == '(') {
          count++;
          if (count > 1) sb.append(c);
        } else if (c == ')') {
          count--;
          if (count > 0) sb.append(c);
        }
      }

      return sb.toString();
    }
  }
}
