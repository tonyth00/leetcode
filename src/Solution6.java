import java.util.LinkedList;
import java.util.List;

/**
 * Solution6
 */
public class Solution6 {

  public static void main(String[] args) {
    System.out.println(new Solution().convert("ABCD", 3));
  }

  static class Solution {
    public String convert(String s, int numRows) {
      if (numRows == 1)
        return s;

      List<Integer> pivots = new LinkedList<>();
      StringBuilder sb = new StringBuilder();

      int spacing = 2 + (numRows - 2) * 2;
      for (int i = 0; i < s.length(); i += spacing) {
        pivots.add(i);
        sb.append(s.charAt(i));
      }

      int jumps = spacing - 2;
      int hop = 1;

      while (sb.length() < s.length()) {

        for (Integer pivot : pivots) {
          int index = pivot + hop;
          if (index >= 0 && index < s.length()) {
            sb.append(s.charAt(index));
          }
          if (jumps > 0) {
            index += jumps;
            if (index >= 0 && index < s.length()) {
              sb.append(s.charAt(index));
            }
          }

        }
        jumps -= 2;
        hop++;
      }

      return sb.toString();

    }
  }
}