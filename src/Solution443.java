
public class Solution443 {
  public static void main(String[] args) {
    System.out.println(new Solution().compress(new char[] {'a', 'b', 'b', 'b'}));
  }

  static class Solution {
    public int compress(char[] chars) {
      int i = 0;
      int j = 0;
      int count = 0;
      int n = chars.length;
      while (j < n) {
        count++;
        if (j == n - 1 || chars[j] != chars[j + 1]) {
          chars[i++] = chars[j];
          if (count > 1) {
            char[] num = Integer.toString(count).toCharArray();
            for (char digit : num) chars[i++] = digit;
          }
          count = 0;
        }
        j++;

      }
      return i;
    }
  }
}
