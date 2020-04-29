import java.util.List;
import java.util.ArrayList;

public class Solution93 {
  public static void main(String[] args) {
    System.out.println(new Solution().restoreIpAddresses("010010"));
  }

  static class Solution {
    /**
     * Intuition:
     * Use backtracking, make valid cuts where possible, and recurse the remaining uncut string.

     * We are performing three cuts total. There are only three ways to make each cut.
     * Hence, O(3^3) = O(27) time.
     * 
     */
    public List<String> restoreIpAddresses(String s) {
      List<String> res = new ArrayList<>();
      backtrack(s, 0, 0, res, new int[4]);
      return res;
    }

    private void backtrack(String s, int start, int k, List<String> res, int[] keys) {
      if (start == s.length() && k == 4) {
        res.add(buildString(keys));
      } else if (start == s.length() || k == 4) {
        return;
      } else {
        int key = 0;
        for (int i = start; i < s.length() && i < start + 3; i++) {
          key = key * 10 + s.charAt(i) - '0';
          if (key < 256) {
            keys[k] = key;
            backtrack(s, i + 1, k + 1, res, keys);
          }
          if (key == 0) break; // keys cannot have leading 0 (such as 02) except 0 itself.
        }
      }
    }

    private String buildString(int[] keys) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < keys.length; i++) {
        sb.append(keys[i]);
        if (i != keys.length - 1)
          sb.append('.');
      }
      return sb.toString();
    }
  }
}
