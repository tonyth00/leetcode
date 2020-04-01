/**
 * Solution541
 */
public class Solution541 {

  public static void main(String[] args) {
    System.out.println(new Solution().reverseStr("abcdefg", 2));
  }

  static class Solution {
    public String reverseStr(String s, int k) {
      char[] a = s.toCharArray();
      int N = s.length();
      for (int i = 0; i < N; i += 2*k) {
        reverse(a, i, Math.min(i + k - 1, N - 1));
      }
      return String.valueOf(a);
    }
    private void reverse(char[] a, int left, int right) {
      while (left < right) {
        char temp = a[left];
        a[left++] = a[right];
        a[right--] = temp;
      }
    }
  }
}