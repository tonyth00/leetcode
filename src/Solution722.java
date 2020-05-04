import java.util.List;
import java.util.ArrayList;

public class Solution722 {
  public static void main(String[] args) {
    String[] source = {
      "/*Test program */", 
      "int main()", 
      "{ ", 
      "  // variable declaration ",
      "int a, b, c;", 
      "/* This is a test", 
      "   multiline  ", 
      "   comment for ", 
      "   testing */",
      "a = b + c;", "}"
    };
    System.out.println(new Solution().removeComments(source));
  }

  static class Solution {
    /**
     * Intuition:
     * Store a state, stipulating whether we are:
     * 0: code
     * 1: line comment
     * 2: block comment
     * 
     * Code should be pretty straightforward:
     * If we're in state 0 and we see "//" switch to state 1 (line comment), 
     * and if we see "/*" switch to state 2 (block comment).
     * 
     * If we're at the end of the line, and we're in state 0 or 1, 
     * add string to result if not empty.
     */
    public List<String> removeComments(String[] source) {
      int state = 0;
      StringBuilder sb = new StringBuilder();
      List<String> res = new ArrayList<>();
      for (String line : source) {
        for (int i = 0; i < line.length(); i++) {
          char c = line.charAt(i);
          if (state == 0) {
            if (line.startsWith("//", i)) {
              state = 1; i++;
            } else if (line.startsWith("/*", i)) {
              state = 2; i++;
            } else {
              sb.append(c);
            }
          } else if (state == 2) {
            if (line.startsWith("*/", i)) {
              state = 0; i++;
            }
          }

          if (i == line.length() - 1) {
            if (state == 0 || state == 1) {
              if (sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
              }
              state = 0;
            }
          }
        }
      }
      return res;
    }
  }
}
