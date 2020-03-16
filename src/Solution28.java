/**
 * Solution28
 */
public class Solution28 {

  public static void main(String[] args) {
    String haystack = "aaaaa";
    String needle = "bba";
    System.out.println(new Solution().strStr(haystack, needle));
  }

  static class Solution {
    public int strStr(String haystack, String needle) {
      if (needle == null || haystack == null) return -1;
      if (needle.length() == 0) return 0;
      for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        if (haystack.charAt(i) == needle.charAt(0)) {
          boolean found = true;
          for (int j = 1; j < needle.length(); j++) {
            if (haystack.charAt(i + j) != needle.charAt(j)) {
              found = false;
              break;
            }
          }
          if (found) {
            return i;
          }
        }
      }


      return -1;
    }
  }
}