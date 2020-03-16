import java.util.HashSet;

/**
 * Solution1012
 */
public class Solution1012 {

  public static void main(String[] args) {
    System.out.println(new Solution().numDupDigitsAtMostN(1000));
  }

  static class Solution {
    public int numDupDigitsAtMostN(int N) {
      int count = 0;
      HashSet<Integer> set = new HashSet<>();
      for (int i = 11; i <= N; i++) {
        set.clear();
        
        int j = i;
        while (j > 0) {
          int digit = j % 10;
          if (set.contains(digit)) {
            count++;
            break;
          } else {
            set.add(digit);
          }
          j /= 10;
        }
      }
      return count;
    }
  }
}