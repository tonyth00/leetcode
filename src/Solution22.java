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
      backtrack(n, list, new char[n*2], 0, 0);
      return list;
    }
    
    /**
     * O(2^n) upper bound time.
     */
    public void backtrack(int n, List<String> res, char[] ch, int open, int close) {
      if (open + close == 2*n) res.add(new String(ch));
      else {
        int i = open + close;
        
        if (open < n) {
          ch[i] = '(';
          backtrack(n, res, ch, open + 1, close);
        }

        if (close < open) {
          ch[i] = ')';
          backtrack(n, res, ch, open, close + 1);
        }
      }
    }
  }
}