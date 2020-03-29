import java.util.*;

class Solution451 {
  public static void main(String[] args) {
    System.out.println(new Solution().frequencySort("Aabb"));
  }

  static class Solution {

    public String frequencySort(String s) {
      if (s == null || s.length() <= 2) return s;
      Map<Character, Integer> map = new HashMap<>();
      int maxCount = 0;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        map.put(c, map.getOrDefault(c, 0) + 1);
        maxCount = Math.max(maxCount, map.get(c));
      }

      List<Character>[] buckets = new List[maxCount + 1];

      for (char c : map.keySet()) {
        int count = map.get(c);
        if (buckets[count] == null) buckets[count] = new ArrayList<>();
        buckets[count].add(c);
      }

      StringBuilder sb = new StringBuilder();
      for (int i = buckets.length - 1; i >= 0; i--) {
        List<Character> bucket = buckets[i];
        if (bucket != null) {
          for (char c : bucket) {
            for (int j = 0; j < i; j++) {
              sb.append(c);
            }
          }
        }
      }
      return sb.toString();
    }
  }
}