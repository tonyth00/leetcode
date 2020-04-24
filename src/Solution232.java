import java.util.Deque;
import java.util.ArrayDeque;
public class Solution232 {
  public static void main(String[] args) {

  }

  static class MyQueue {
    Deque<Integer> stack;
    Deque<Integer> temp;

    /** Initialize your data structure here. */
    public MyQueue() {
      stack = new ArrayDeque<>();
      temp = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
      for (int i = 0; i < stack.size(); i++) {
        temp.push(stack.pop());
      }
      stack.push(x);
      for (int i = 0; i < temp.size(); i++) {
        stack.push(temp.pop());
      }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
      return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return stack.isEmpty();
    }
  }
}
