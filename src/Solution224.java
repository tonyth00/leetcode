import java.util.ArrayDeque;
import java.util.Deque;

public class Solution224 {
  public static void main(String[] args) {
    System.out.println(new Solution().calculate("(5-6)-1"));
  }

  static class Solution {
    public int calculate(String s) {
      Deque<Integer> nums = new ArrayDeque<>();
      Deque<Character> ops = new ArrayDeque<>();
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
          int num = c - '0';
          while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
            num = num * 10 + s.charAt(i + 1) - '0';
            i++;
          }
          nums.push(num);
        } else if (c == '(') {
          ops.push(c);
        } else if (c == ')') {
          while (ops.peek() != '(') nums.push(calc(nums.pop(), nums.pop(), ops.pop()));
          ops.pop();
        } else if (c == '+' || c == '-') {
          while (!ops.isEmpty() && hasHigherPrecedence(ops.peek(), c)) {
            nums.push(calc(nums.pop(), nums.pop(), ops.pop()));
          }
          ops.push(c);
        }
      }
      while (!ops.isEmpty()) {
        nums.push(calc(nums.pop(), nums.pop(), ops.pop()));
      }

      return nums.pop();
    }

    private boolean hasHigherPrecedence(char c, char d) {
      if (c == '(') return false;
      return true;
    }

    private int calc(int b, int a, char c) {
      switch (c) {
        case '+':
          return a + b;
        case '-':
          return a - b;
      }
      return -1;
    }
  }
}
