import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import shared.Helper;

/**
 * Solution599
 */
public class Solution599 {

  public static void main(String[] args) {
    String[] arr1 = { "Shogun", "Tapioca Express", "Burger King", "Piatti" };
    String[] arr2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
    Helper.print(new Solution().findRestaurant(arr1, arr2));
  }

  static class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
      Map<String, Integer> map = new HashMap<>();
      for (int i = 0; i < list1.length; i++) {
        map.put(list1[i], i);
      }

      List<String> res = new LinkedList<>();
      int minSum = Integer.MAX_VALUE;

      for (int i = 0; i < list2.length; i++) {
        Integer val = map.get(list2[i]);
        if (val != null && val + i <= minSum) {
          if (val + i < minSum) {
            res.clear();
          }
          minSum = val + i;
          res.add(list2[i]);
        }
      }

      return res.toArray(new String[res.size()]);
    }
  }
}