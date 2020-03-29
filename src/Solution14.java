/**
 * Solution14
 */
public class Solution14 {

  public static void main(String[] args) {
    String[] strs = { "flower", "flow", "flight" };
    System.out.println(new Solution().longestCommonPrefix(strs));
  }

  static class Solution {
    public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) return "";

      int i = 0;
      while (i < strs[0].length()) {
        char c = strs[0].charAt(i);

        for (String word : strs) {
          if (i >= word.length() || word.charAt(i) != c) return strs[0].substring(0, i);
        }
        i++;
      }
      return strs[0].substring(0, i);
    }
  }
}