public class Solution953 {
  public static void main(String[] args) {
    String[] words = {"hello","leetcode"};
    System.out.println(new Solution().isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
  }

  static class Solution {
    public boolean isAlienSorted(String[] words, String order) {
      int[] map = new int[26];
      for (int i = 0; i < order.length(); i++) {
        map[order.charAt(i) - 'a'] = i;
      }
      for (int i = 0; i < words.length - 1; i++) {
        if (!compareOrder(words[i], words[i + 1], map)) return false;
      }

      return true;
    }

    private boolean compareOrder(String w1, String w2, int[] map) {
      int len = Math.min(w1.length(), w2.length());
      for (int j = 0; j < len; j++) {
        char c1 = w1.charAt(j);
        char c2 = w2.charAt(j);
        if (c1 != c2) {
          return map[c1 - 'a'] < map[c2 - 'a'];
        }
      }

      return w1.length() <= w2.length();
    }
  }
}