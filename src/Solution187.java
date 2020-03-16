import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Solution187
 */
public class Solution187 {

  public static void main(String[] args) {
    System.out.println(new Solution().findRepeatedDnaSequences("AAAAAAAAAA"));
  }

  static class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      HashSet<String> repeated = new HashSet<>();
      HashSet<String> seen = new HashSet<>();

      for (int i = 0; i <= s.length() - 10; i++) {
        String ten = s.substring(i, i + 10);
        if (!seen.add(ten)) {
          repeated.add(ten);
        }
      }

      return new ArrayList<>(repeated);

    }
  }
}