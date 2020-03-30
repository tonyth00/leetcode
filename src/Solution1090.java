import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution1090
 */
public class Solution1090 {

  public static void main(String[] args) {
    int[] values = { 9, 8, 8, 7, 6 };
    int[] labels = { 0, 0, 0, 1, 1 };
    System.out.println(new Solution().largestValsFromLabels(values, labels, 3, 1));
  }

  static class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
      int n = values.length;
      int[][] vl = new int[n][2];
      for (int i = 0; i < n; i++) {
        vl[i][0] = values[i];
        vl[i][1] = labels[i];
      }
      Arrays.sort(vl, (a, b) -> Integer.compare(b[0], a[0]));
      
      Map<Integer, Integer> labelCount = new HashMap<>();

      int sum = 0;
      int used = 0;
      for (int[] v : vl) {
        if (used < num_wanted) {
          int numLabels = labelCount.getOrDefault(v[1], 0);
          if (numLabels + 1 <= use_limit) {
            sum += v[0];
            used++;
            labelCount.put(v[1], numLabels + 1);
          }
        } else {
          break;
        }
      }
      return sum;
    }
  }
}