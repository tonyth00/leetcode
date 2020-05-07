import shared.Helper;
public class Solution186 {
  public static void main(String[] args) {
    char[] s = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
    new Solution().reverseWords(s);
    Helper.print(s);
  }

  static class Solution {
    public void reverseWords(char[] s) {
      reverse(s, 0, s.length - 1);
      int i = 0;
      while (i < s.length) {
        if (s[i] != ' ') {
          int j = i;
          while (j + 1 < s.length && s[j + 1] != ' ') j++;
          reverse(s, i, j);
          i = j + 1;
        } else {
          i++;
        }
      }
    }

    private void reverse(char[] s, int i, int j) {
      while (i < j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        i++;
        j--;
      }
    }
  }
}
