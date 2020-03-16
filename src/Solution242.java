/**
 * Solution242
 */
public class Solution242 {

  public static void main(String[] args) {
    System.out.println(new Solution().isAnagram("aacc", "ccac"));
  }

  static class Solution {
    public boolean isAnagram(String s, String t) {
      if (s == null || t == null || s.length() != t.length())
        return false;

      int len = s.length();
      
      int[] table = new int[26];
      for (int i = 0; i < len; i++) {
        table[s.charAt(i) - 'a']++;
      }
      for (int i = 0; i < len; i++) {
        if (table[t.charAt(i) - 'a'] == 0) return false;
        table[t.charAt(i) - 'a']--;
      }


      return true;
    }
  }
}