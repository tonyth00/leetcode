import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution18 {
  public static void main(String[] args) {
    int[] nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    System.out.println(new Solution().fourSum(nums, target));
  }

  static class Solution {
    public List<List<Integer>> fourSum(int[] v, int target) {
      List<List<Integer>> res = new ArrayList<>();
      int n = v.length;
      if (n < 4) return res;
      Arrays.sort(v);

      int low = v[0] + v[1] + v[2] + v[3];
      if (low > target)
        return res;
      int high = v[n - 1] + v[n - 2] + v[n - 3] + v[n - 4];
      if (high < target)
        return res;

      for (int k = 0; k < n - 3; k++) {
        if (k > 0 && v[k - 1] == v[k]) continue;
        for (int l = k + 1; l < n - 2; l++) {
          if (l > k + 1 && v[l - 1] == v[l]) continue;
          int i = l + 1; int j = n - 1;
          while (i < j) {
            int sum = v[k] + v[l] + v[i] + v[j];
            if (sum == target) {
              res.add(Arrays.asList(v[k], v[l], v[i], v[j]));
              i++;
              j--;
              while (i < j && v[i] == v[i - 1]) i++;
              while (i < j && v[j] == v[j + 1]) j--;
            } else if (sum < target) {
              i++;
              while (i < j && v[i] == v[i - 1]) i++;
            } else if (sum > target) {
              j--;
              while (i < j && v[j] == v[j + 1]) j--;
            }
          }
        }
      }
      return res;
    }
  }
}
