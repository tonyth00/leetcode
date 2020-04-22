import java.util.ArrayDeque;
import java.util.Deque;

public class Solution227 {
  public static void main(String[] args) {
    System.out.println(new Solution().calculate(" 3+2 * 2 "));
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
            num = num * 10 + (s.charAt(i + 1) - '0');
            i++;
          }
          nums.push(num);
        } else if (c == '*' || c == '/') {
          while (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
            nums.push(calc(nums.pop(), nums.pop(), ops.pop()));
          }
          ops.push(c);
        } else if (c == '+' || c == '-') {
          while (!ops.isEmpty()) {
            nums.push(calc(nums.pop(), nums.pop(), ops.pop()));
          };
          ops.push(c);
        }
      }

      while (!ops.isEmpty()) {
        nums.push(calc(nums.pop(), nums.pop(), ops.pop()));
      };
      return nums.pop();
    }

    private int calc(int b, int a, char c) {
      switch (c) {
        case '+':
          return a + b;
        case '-':
          return a - b;
        case '*':
          return a * b;
        case '/':
          return a / b;
        default: 
          return 0;
      }
    }



    public int calculate2(String s) {
      Deque<Integer> stack = new ArrayDeque<>();

      char sign = '+';
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
          int num = c - '0';
          while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
            num = num*10 + (s.charAt(i + 1) - '0');
            i++;
          }
          if (sign == '+') stack.push(num);
          else if (sign == '-') stack.push(-num);
          else if (sign == '/') {
            stack.push(stack.pop()/num);
          } else {
            stack.push(stack.pop()*num);
          }
        } else if (c != ' ') {
          sign = c;
        }
      }

      int result = 0;
      while (!stack.isEmpty()) {
        result += stack.pop();
      }


      return result;
    }
  }
}
