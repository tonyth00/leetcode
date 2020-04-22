
public class Solution38 {
  public static void main(String[] args) {
    System.out.println(new Solution().countAndSay(5));
  }

  static class Solution {
    public String countAndSay(int n) {
      if (n == 1) return "1";

      StringBuilder prev = new StringBuilder("1");
      while (n > 1) {
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < prev.length();) {
          char c = prev.charAt(i);
          int j = i + 1;
          while (j < prev.length() && prev.charAt(j) == c) j++;
          cur.append(j - i).append(c);
          i = j;
        }
        prev = cur;
        n--;
      }

      return prev.toString();

    }
  }
}