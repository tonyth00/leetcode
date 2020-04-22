import java.util.HashMap;
import java.util.Map;

public class Solution146 {
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));
    cache.put(3, 3);
    System.out.println(cache.get(2));
    cache.put(4, 4);
    System.out.println(cache.get(1));
  }

  static class LRUCache {
    class Node {
      public Node prev = null;
      public Node next = null;
      public int value;
      public int key;

      public Node(int key, int value) {
        this.value = value;
        this.key = key;
      }
    }

    int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      map = new HashMap<>(capacity);
      head = new Node(-1, -1);
      tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      if (!map.containsKey(key))
        return -1;

      insert(remove(map.get(key)));
      return map.get(key).value;
    }

    private Node remove(Node node) {
      if (node == tail)
        tail = node.prev;

      node.prev.next = node.next;
      node.next.prev = node.prev;

      node.next = null;
      return node;
    }

    private void insert(Node node) {
      tail.prev.next = node;
      node.prev = tail.prev;

      node.next = tail;
      tail.prev = node;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        node.value = value;
        insert(remove(node));
        return;
      } else if (map.size() == capacity) {
        Node node = head.next;
        remove(node);
        map.remove(node.key);
      }
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      insert(newNode);
    }
  }
}
