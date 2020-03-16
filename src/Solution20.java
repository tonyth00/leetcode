import java.util.HashMap;
import java.util.Stack;

public class Solution20 {

  public static void main(String[] args) {
    System.out.println(new Solution().isValid("{([}])"));
  }

  static class Solution {

    public boolean isValid(String s) {
      if (s.length() % 2 == 1)
        return false;
      Stack<Character> stack = new Stack<>();
      HashMap<Character, Character> map = new HashMap<>();
      map.put('(', ')');
      map.put('[', ']');
      map.put('{', '}');
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (map.containsKey(c)) {
          stack.add(c);
        } else if (map.containsValue(c)) {
          if (stack.isEmpty() || map.get(stack.pop()) != c) return false;
        } else {
          return false;
        }
      }

      return stack.isEmpty();
    }
  }
}