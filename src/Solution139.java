import java.util.Arrays;
import java.util.List;

/**
 * Solution139
 */
public class Solution139 {

  public static void main(String[] args) {
    System.out.println(new Solution().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
  }

  static class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      int len = s.length();
      boolean[] v = new boolean[len + 1];
      v[0] = true;

      for (int i = 0; i < len; i++) {
        if (!v[i])
          continue;

        String substr = s.substring(i);
        for (String word : wordDict) {
          if (substr.startsWith(word)) {
            v[i + word.length()] = true;
          }
        }
      }

      return v[len];
    }

  }
}