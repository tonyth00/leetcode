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
      if (strs == null || strs.length == 0)
        return "";

      int index = 0;
      char match;
      while (strs.length > 0 && index < strs[0].length()) {
        match = strs[0].charAt(index);

        for (String word : strs) {
          if (index < word.length() && word.charAt(index) == match) {
            continue;
          } else {
            return strs[0].substring(0, index);
          }
        }
        index++;
      }
      return strs[0].substring(0, index);
    }
  }
}