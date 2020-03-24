import java.util.PriorityQueue;

/**
 * Solution295
 */
public class Solution295 {

  public static void main(String[] args) {
    MedianFinder mf = new MedianFinder();
    mf.addNum(117);
    mf.addNum(309);
    mf.addNum(156);
    System.out.println(mf.findMedian());
  }

  static class MedianFinder {
    PriorityQueue<Integer> upperHeap = new PriorityQueue<>();
    PriorityQueue<Integer> lowerHeap = new PriorityQueue<>((a, b) -> -1 * Integer.compare(a, b));

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
      if (lowerHeap.isEmpty() || num <= lowerHeap.peek()) {
        lowerHeap.add(num);
      } else {
        upperHeap.add(num);
      }
      rebalance();
    }

    private void rebalance() {
      PriorityQueue<Integer> largerHeap = lowerHeap.size() > upperHeap.size() ? lowerHeap : upperHeap;
      PriorityQueue<Integer> smallerHeap = lowerHeap.size() > upperHeap.size() ? upperHeap : lowerHeap;

      if (largerHeap.size() - smallerHeap.size() >= 2) {
        smallerHeap.add(largerHeap.remove());
      }
    }

    public double findMedian() {
      if (lowerHeap.size() == upperHeap.size()) return (lowerHeap.peek() + upperHeap.peek()) / 2f;
      PriorityQueue<Integer> largerHeap = lowerHeap.size() > upperHeap.size() ? lowerHeap : upperHeap;
      return largerHeap.peek();
    }
  }
}