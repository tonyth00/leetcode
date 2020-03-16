import java.util.LinkedList;
import java.util.List;

/**
 * Solution22
 */
public class Solution22 {

  public static void main(String[] args) {
    System.out.println(new Solution().generateParenthesis(3));
  }

  static class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> list = new LinkedList<>();
      helper(n, list, "", 0, 0);
      return list;
    }

    public void helper(int n, List<String> list, String s, int numOpen, int numClose) {
      if (numOpen == n && numClose == n) {
        list.add(s);
      } else {
        if (numOpen < n) {
          helper(n, list, s + "(", numOpen + 1, numClose);
        }
        if (numClose < n && numOpen > numClose) {
          helper(n, list, s + ")", numOpen, numClose + 1);
        }
      }
    }
  }
}