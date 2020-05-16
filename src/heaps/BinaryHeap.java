package heaps;

import java.util.EmptyStackException;

public class BinaryHeap {
  public static void main(String[] args) {
    BinaryHeap q = new BinaryHeap();
    q.insert(5);
    q.insert(1);
    q.insert(2);
    q.insert(9);
    q.insert(3);
    q.insert(4);
    q.insert(3);
    q.insert(4);
    q.insert(3);

    System.out.println(q.peek());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
  }

  private Integer[] heap = null;
  private int heapSize = 0;
  public BinaryHeap() {
    heap = new Integer[1];
  }

  public Integer peek() {
    if (isEmpty()) throw new EmptyStackException();
    return heap[0];
  }

  /**
   * Expand if full
   */
  public void insert(int value) {
    if (isFull()) expand();
    heap[heapSize] = value;
    bubbleUp(heapSize);
    heapSize++;
  }

  private void expand() {
    Integer[] newHeap = new Integer[heapSize * 2];
    System.arraycopy(heap, 0, newHeap, 0, heapSize);
    heap = newHeap;
  }

  private boolean isFull() {
    return heapSize == heap.length;
  }

  public boolean isEmpty() {
    return heapSize == 0;
  }

  public int size() {
    return heapSize;
  }

  public Integer poll() {
    if (isEmpty()) throw new EmptyStackException();
    Integer removedElement = heap[0];
    heapSize--;
    swap(0, heapSize);
    heap[heapSize] = null;
    bubbleDown(0);
    return removedElement;
  }

  private void bubbleDown(int k) {
    if (k >= heapSize) return; // return if empty

    int value = heap[k];
    while (k < heapSize) {
      int left = 2*k + 1;
      int right = 2*k + 2;
      if (left >= heapSize) break;
      int smallest = left;
      if (right < heapSize && heap[left] > heap[right]) smallest = right;
      if (heap[smallest] >= value) break;
      heap[k] = heap[smallest];
      k = smallest;
    }
    heap[k] = value;
  }

  private void bubbleUp(int k) {
    int value = heap[k];
    while (k > 0 && value < heap[parentIndex(k)]) {
      heap[k] = heap[parentIndex(k)];
      k = parentIndex(k);
    }
    heap[k] = value;
  }

  private int parentIndex(int k) {
    return (k - 1)/2;
  }

  private void swap(int i, int j) {
    Integer temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }
}
