
public class Solution459 {
  public static void main(String[] args) {
    System.out.println(new Solution().repeatedSubstringPattern("abcabcd"));
  }

  static class Solution {
    public boolean repeatedSubstringPattern(String s) {
      char[] ch = s.toCharArray();
      int len = ch.length;
      for (int subLen = 1; subLen <= len / 2; subLen++) {
        if (len % subLen != 0) continue;
        int j = 0;
        int k = subLen;
        while (k < len) {
          if (ch[j] == ch[k]) {
            j = (j + 1) % subLen;
            k++;
          } else {
            break;
          }
        }
        if (k == len) return true;
      }

      return false;
    }
  }
}