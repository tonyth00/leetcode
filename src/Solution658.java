import java.util.List;
import java.util.ArrayList;
public class Solution658 {
  public static void main(String[] args) {
    System.out.println(new Solution().findClosestElements(new int[] {1, 2, 3, 4, 5}, 4, 3));
  }

  static class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int l = 0;
      int r = arr.length - k + 1;
      while (l < r) {
        int m = l + (r - l)/2;
        System.out.println(m);
        if (arr[m + k - 1] - x >= x - arr[m]) r = m;
        else l = m + 1;
      }

      List<Integer> res = new ArrayList<>();
      for (int i = l; i < l + k; i++) {
        res.add(arr[i]);
      }

      return res;
    }
  }
}