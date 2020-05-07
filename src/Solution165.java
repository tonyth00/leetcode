public class Solution165 {
  public static void main(String[] args) {
    System.out.println(new Solution().compareVersion("01", "1"));
  }

  static class Solution {
    public int compareVersion(String s, String t) {
      int i = 0;
      int j = 0;
      int m = s.length();
      int n = t.length();
      while (i < m || j < n) {
        int num1 = 0;
        while (i < m && s.charAt(i) != '.') num1 = num1*10 + s.charAt(i++) - '0';
        i++;

        int num2 = 0;
        while (j < n && t.charAt(j) != '.') num2 = num2*10 + t.charAt(j++) - '0';
        j++;

        if (num1 != num2) return Integer.compare(num1, num2);
      }

      return 0;
    }
  }
}
