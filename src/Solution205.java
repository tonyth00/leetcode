public class Solution205 {
  public static void main(String[] args) {
    System.out.println(new Solution().isIsomorphic("aa", "ba"));
  }

  static class Solution {
    public boolean isIsomorphic(String s, String t) {
      if (s.length() != t.length()) return false;
      int[] map = new int[256];
      boolean[] set = new boolean[256];
      
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        char d = t.charAt(i);
        if (map[c] == 0) {
          if (set[d]) return false;
          map[c] = d;
          set[d] = true;
        } else {
          if (map[c] != d) return false;
        }
      }

      return true;
    }
  }
}