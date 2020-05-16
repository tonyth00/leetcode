import java.util.Set;
import java.util.HashSet;
public class Solution804 {
  public static void main(String[] args) {
    System.out.println(
        new Solution().uniqueMorseRepresentations(new String[] {"gin", "zen", "gig", "msg"}));
  }

  static class Solution {
    

    public int uniqueMorseRepresentations(String[] words) {
      final String[] map = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
        "-..-", "-.--", "--.."};
      Set<String> set = new HashSet<>();
      
      for (String word : words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) sb.append(map[word.charAt(i)  - 'a']);
        set.add(sb.toString());
      }
      return set.size();
    }
  }
}
