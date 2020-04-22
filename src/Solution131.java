import java.util.*;
public class Solution131 {
  public static void main(String[] args) {
    System.out.println(new Solution().partition("aab"));
  }

  static class Solution {
    public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<>();
      backtrack(s, 0, new ArrayList<>(), res);
      return res;
    }

    private void backtrack(String s, int start, List<String> cur, List<List<String>> res) {
      if (start == s.length()) {
        res.add(new ArrayList<>(cur));
      } else {
        for (int i = start; i < s.length(); i++) {
          if (isPalindrome(s, start, i)) {
            cur.add(s.substring(start, i + 1));
            backtrack(s, i + 1, cur, res);
            cur.remove(cur.size() - 1);
          }
        }
      }
    }
    
    private boolean isPalindrome(String s, int i, int j) {
      while (i < j) {
        if (s.charAt(i++) != s.charAt(j--)) return false;
      }
      return true;
    }
  }
}