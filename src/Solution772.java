import java.util.ArrayDeque;
import java.util.Deque;

public class Solution772 {
  public static void main(String[] args) {
    System.out.println(new Solution().calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
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
          };
          nums.push(num);
        } else if (c == '(') {
          ops.push(c);
        } else if (c == ')') {
          while (ops.peek() != '(') {
            nums.push(calc(nums.pop(), nums.pop(), ops.pop()));
          }
          ops.pop();
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {
          if (c == '-') {
            int j = i - 1;
            while (j >= 0 && s.charAt(j) == ' ') j--;
            if (j < 0 || j >= 0 && s.charAt(j) == '(') nums.push(0);
          }


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

    private boolean hasHigherPrecedence(char o1, char o2) {
      if (o1 == '(' || o1 == ')') return false;
      if ((o1 == '-' || o1 == '+') && (o2 == '*' || o2 == '/')) return false;
      return true;
    };

    private int calc(int b, int a, char op) {
      switch (op) {
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
      int l1 = 0, o1 = 1;
      int l2 = 1, o2 = 1;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
          int num = c - '0';
          while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
            num = num*10 + (s.charAt(i + 1) - '0');
            i++;
          }
          l2 = o2 == 1 ? l2*num : l2/num;
        } else if (c == '(') {
          stack.push(l1); stack.push(o1);
          stack.push(l2); stack.push(o2);
          l1 = 0; o1 = 1;
          l2 = 1; o2 = 1;
        } else if (c == ')') {
          int num = l1 + o1*l2;

          o2 = stack.pop(); l2 = stack.pop();
          o1 = stack.pop(); l1 = stack.pop();

          l2 = o2 == 1 ? l2*num : l2/num;
        } else if (c == '/' || c == '*') {
          o2 = c == '*' ? 1 : -1;
        } else if (c == '+' || c == '-' ) {
          if (c == '-' && (i == 0 || s.charAt(i - 1) == '(')) {
            o1 = -1;
            continue;
          }
          l1 = l1 + o1*l2;
          l2 = 1; o2 = 1;

          o1 = c == '+' ? 1 : -1;
        }
      }

      return l1 + o1*l2;
    }
  }
}