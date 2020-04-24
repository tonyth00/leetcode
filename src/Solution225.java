import java.util.Deque;
import java.util.ArrayDeque;

public class Solution225 {
  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(5);
    stack.push(6);
    System.out.println(stack.pop());
    System.out.println(stack.top());
  }

  static class MyStack {
    Deque<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
      queue = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
      queue.add(x);
      for (int i = 1; i < queue.size(); i++) {
        queue.add(queue.remove());
      }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      return queue.remove();
    }

    /** Get the top element. */
    public int top() {
      return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
      return queue.isEmpty();
    }
  }
}
