public class Solution521 {
  public static void main(String[] args) {
    System.out.println(new Solution().findLUSlength("abcd", "abc"));
  }

  static class Solution {
    public int findLUSlength(String a, String b) {
      return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
  }
}
