import java.util.List;
import java.util.LinkedList;
public class Solution706 {
  public static void main(String[] args) {
    MyHashMap hashMap = new MyHashMap();
    hashMap.put(1, 1);
    hashMap.put(2, 2);
    hashMap.get(1); // returns 1
    hashMap.get(3); // returns -1 (not found)
    hashMap.put(2, 1); // update the existing value
    hashMap.get(2); // returns 1
    hashMap.remove(2); // remove the mapping for 2
    hashMap.get(2); // returns -1 (not found)
  }

  static class MyHashMap {
    List<Pair>[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
      buckets = new List[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
      int index = key % buckets.length;
      if (buckets[index] == null) {
        buckets[index] = new LinkedList<>();
      }

      Pair pair = find(buckets[index], key);
      if (pair != null) pair.value = value;
      else buckets[index].add(new Pair(key, value));
    }

    private Pair find(List<Pair> bucket, int key) {
      for (Pair pair : bucket) {
        if (key == pair.key) return pair;
      }
      return null;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public int get(int key) {
      int index = key % buckets.length;
      if (buckets[index] == null) return -1;

      Pair pair = find(buckets[index], key);
      return pair != null ? pair.value : -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
      int index = key % buckets.length;
      if (buckets[index] == null) return;

      Pair pair = find(buckets[index], key);
      if (pair != null) buckets[index].remove(pair);
    }

    class Pair {
      int key;
      int value;
      public Pair(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }
  }
}
