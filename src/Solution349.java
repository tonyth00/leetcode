import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import shared.Helper;

public class Solution349 {
  public static void main(String[] args) {
    Helper.print(new Solution().intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));
  }

  static class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      Set<Integer> set = new HashSet<>();
      for (int num : nums1)
        set.add(num);

      List<Integer> res = new ArrayList<>();
      for (int num : nums2) {
        if (set.contains(num)) {
          set.remove(num);
          res.add(num);
        }
      }

      int[] arr = new int[res.size()];
      for (int i = 0; i < res.size(); i++) arr[i] = res.get(i);

      return arr;
    }
  }
}