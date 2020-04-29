public class Solution65 {
  public static void main(String[] args) {
    System.out.println(new Solution().isNumber("46.e3"));
  }

  static class Solution {
      /**
       * Regex solution. Works but slow.
       */
      public boolean isNumber2(String s) {
        s = s.trim();
        return s.matches("[+-]?(\\d+|(\\d+\\.\\d*)|(\\d*\\.\\d+))(e[+-]?\\d+)?");
      }

      // Solution using DFA
      // Link: https://leetcode.com/problems/valid-number/discuss/23725/C%2B%2B-My-thought-with-DFA
      public boolean isNumber(String s) {
        s = s.trim();
        int state = 1;
        for (char c : s.toCharArray()) {
          if (c >= '0' && c <= '9') {
            if (state == 1 || state == 2) state = 3;
            else if (state == 5 || state == 6) state = 7;
            else if (state == 3 || state == 4 || state == 7) {}
            else if (state == 8) state = 4;
            else return false;
          } else if (c == '+' || c == '-') {
            if (state == 1) state = 2;
            else if (state == 5) state = 6;
            else return false;
          } else if (c == '.') {
            if (state == 3) state = 4;
            else if (state == 1) state = 8;
            else if (state == 2) state = 8;
            else return false; 
          } else if (c == 'e') {
            if (state == 3 || state == 4) state = 5;
            else return false;
          } else {
            return false;
          }
        }
        
        return state == 3 || state == 4 || state == 7;
      }
  }
}