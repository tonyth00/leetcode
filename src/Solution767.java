import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution767
 */
public class Solution767 {

  public static void main(String[] args) {
    System.out.println(new Solution().reorganizeString("aaab"));
  }

  static class Solution {
    public String reorganizeString(String S) {
      int[] hash = new int[26];
      int letter = 0;
      int max = 0;
      for (int i = 0; i < S.length(); i++) {
        int j = S.charAt(i) - 'a';
        hash[j]++;
        if (hash[j] > max) {
          max = hash[j];
          letter = j;
        }
      }

      if (max > (S.length() + 1) / 2) return "";

      char[] res = new char[S.length()];
      int index = 0;
      while (hash[letter] > 0) {
        res[index] = (char)('a' + letter);
        index += 2;
        hash[letter]--;
      }

      for (int i = 0; i < 26; i++) {
        while (hash[i] > 0) {
          if (index >= S.length()) index = 1;
          res[index] = (char)('a' + i);
          index += 2;
          hash[i]--;
        }
      }

      return new String(res);
    }

    public String reorganizeString2(String S) {
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < S.length(); i++) {
        char c = S.charAt(i);
        map.put(c, map.getOrDefault(c, 0) + 1);
      }

      PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));
      maxHeap.addAll(map.keySet());

      StringBuilder sb = new StringBuilder();
      while (maxHeap.size() > 1) {
        char a = maxHeap.remove();
        char b = maxHeap.remove();
        sb.append(a).append(b);
        map.put(a, map.get(a) - 1);
        map.put(b, map.get(b) - 1);
        if (map.get(a) > 0) maxHeap.add(a);
        if (map.get(b) > 0) maxHeap.add(b);
      }

      if (maxHeap.size() > 0) {
        char c = maxHeap.remove();
        if (map.get(c) > 1) return "";
        sb.append(c);
      }
      return sb.toString();
    }
  }
}