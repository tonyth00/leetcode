import java.util.ArrayList;
import java.util.List;

/**
 * Solution9
 */
public class Solution9 {

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome(345543));
  }

  static class Solution {
    public boolean isPalindrome(int x) {
      if (x < 0) return false;

      List<Integer> list = new ArrayList<>();
      while (x > 0) {
        list.add(x % 10);
        x /= 10;
      }
    
      int i = 0;
      int j = list.size() - 1;
      while (i <= j) {
        if (list.get(i) != list.get(j)) return false;
        i++;
        j--;
      }


      return true;
    }
  }
}