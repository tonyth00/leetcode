
public class Solution246 {
  public static void main(String[] args) {
    System.out.println(new Solution().isStrobogrammatic("69"));  
  }

  static class Solution {
    public boolean isStrobogrammatic(String num) {
      char[] map = {'0', '1', '#', '#', '#', '#', '9', '#', '8', '6'};
      int i = 0;
      int j = num.length() - 1;
      while (i <= j) {
        char left = num.charAt(i);
        char right = num.charAt(j);
        if (map[left - '0'] == right && map[right - '0'] == left) {
          i++;
          j--;
        } else {
          return false;
        }
      }
      return true;
    }
  }
}