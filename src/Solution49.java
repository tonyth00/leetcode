import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Solution49
 */
public class Solution49 {

  public static void main(String[] args) {
    System.out.println(new Solution().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
  }

  static class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> groupedAnagrams = new ArrayList<>();

      HashMap<String, List<String>> map = new HashMap<>();
      for (String s : strs) {
        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        String sorted = new String(characters);
        if (!map.containsKey(sorted)) {
          map.put(sorted, new ArrayList<>());
        }

        map.get(sorted).add(s);
      }

      groupedAnagrams.addAll(map.values());

      return groupedAnagrams;

    }
  }
}