import java.util.Deque;
import java.util.ArrayDeque;
public class Solution150 {
  public static void main(String[] args) {
    System.out.println(new Solution().evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
  }

  static class Solution {
    public int evalRPN(String[] tokens) {
      Deque<Integer> stack = new ArrayDeque<>();

      for (String s: tokens) {
        char c = s.charAt(0);
        if (s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')) {
          stack.push(calc(stack.pop(), stack.pop(), c));
        } else {
          stack.push(Integer.parseInt(s));
        }
      }

      return stack.pop();
    }

    private int calc(int b, int a, char op) {
      switch (op) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return a / b;
        default: return Integer.MIN_VALUE;
      }
    }
  }
}