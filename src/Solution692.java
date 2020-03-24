import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/**
 * Solution692
 */
public class Solution692 {

  public static void main(String[] args) {
    System.out.println(new Solution().topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
  }

  static class Solution {
    public List<String> topKFrequent(String[] words, int k) {
      Map<String, Integer> map = new HashMap<>();
      for (String word: words) {
        map.put(word, map.getOrDefault(word, 0) + 1);
      }

      PriorityQueue<Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> {
        if (a.getValue() == b.getValue()) {
          return b.getKey().compareTo(a.getKey());
        } else {
          return Integer.compare(a.getValue(), b.getValue());
        }
      });

      for (Entry<String, Integer> entry : map.entrySet()) {
        queue.add(entry);
        if (queue.size() > k) queue.remove();
      }

      List<String> res = new LinkedList<>();
      while (!queue.isEmpty()) {
        res.add(0, queue.remove().getKey());
      }

      return res;
    }
  }
}