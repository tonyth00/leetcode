/**
 * Solution1055
 */
public class Solution1055 {

  public static void main(String[] args) {
    System.out.println(new Solution().shortestWay("xyz", "xzyxz"));
  }

  static class Solution {
    public int shortestWay(String source, String target) {
      char[] s = source.toCharArray();
      char[] t = target.toCharArray();

      boolean[] has = new boolean[26];
      for (char c : s) {
        has[c - 'a'] = true;
      }

      int i = s.length;
      int count = 0;
      for (int j = 0; j < t.length; j++) {
        if (!has[t[j] - 'a'])
          return -1;

        for (; i <= s.length; i++) {
          if (i == s.length) {
            i = 0;
            count++;
          }
          if (s[i] == t[j])
            break;
        }
        i++;

      }
      return count;
    }
  }
}