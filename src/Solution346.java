import java.util.*;

class Solution346 {
  public static void main(String[] args) {
    MovingAverage ma = new MovingAverage(5);
    System.out.println(ma.next(1));
    System.out.println(ma.next(2));
    System.out.println(ma.next(3));
    System.out.println(ma.next(4));
    System.out.println(ma.next(5));
    System.out.println(ma.next(6));
    System.out.println(ma.next(7));
    System.out.println(ma.next(8));
  }

  static class MovingAverage {
    private Queue<Integer> queue = new LinkedList<>();
    private int sum = 0;
    private int MAX_SIZE = -1;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
      MAX_SIZE = size;
    }
    
    public double next(int val) {
      queue.add(val);
      sum += val;

      if (queue.size() > MAX_SIZE) {
        sum -= queue.remove();
      }

      return (double)sum / queue.size();
    }
  }
}