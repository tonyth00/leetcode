import java.util.ArrayDeque;
import java.util.Deque;

public class Solution394 {
  public static void main(String[] args) {
    System.out.println(new Solution().decodeString("3[a2[c]]"));
  }

  // aaa3[a4[F]c];
  static class Solution {
    /**
     * Intuition:
     * 1. Iterate through string one character at a time
     * 2. For digits, lump together into a multiplier called count
     * 3. For letters, append to string being built
     * 4. For open brackets, stash multiplier into int stack, stash incomplete string onto string stack.
     * 5. A close bracket means we have a completed string inside the current level. Pop
     * multiplier from int stack, multiply the complete string, and append it to the incomplete string from the previous level.
     * 
     */
    public String decodeString(String s) {
      Deque<Integer> intStack = new ArrayDeque<>();
      Deque<StringBuilder> strStack = new ArrayDeque<>();
      StringBuilder cur = new StringBuilder();
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
          count = count*10 + (c - '0');
        } else if (c == '[') {
          intStack.push(count);
          count = 0;
          strStack.push(cur);
          cur = new StringBuilder();
        } else if (c == ']') {
          StringBuilder temp = cur;
          cur = strStack.pop();
          for (int j = 0; j < intStack.pop(); j++) {
            cur.append(temp);
          }
        } else {
          cur.append(c);
        }
      }

      return cur.toString();

    }
  }
}