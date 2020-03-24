import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution347
 */
public class Solution347 {

  public static void main(String[] args) {
    System.out.println(new Solution().topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
  }

  static class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> countMap = new HashMap<>();
      List<Integer>[] buckets = new List[nums.length + 1];
      for (int num : nums) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
      }
      for (int num : countMap.keySet()) {
        int count = countMap.get(num);
        if (buckets[count] == null)
          buckets[count] = new LinkedList<>();
        buckets[count].add(num);
      }

      List<Integer> res = new LinkedList<>();
      for (int i = buckets.length - 1; i > 0 && res.size() < k; i--) {
        if (buckets[i] != null) res.addAll(buckets[i]);
      }
      return res;
    }
  }
}