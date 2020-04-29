import shared.Helper;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class Solution350 {
  public static void main(String[] args) {
    Helper.print(new Solution().intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2}));
  }

  static class Solution {
    public int[] intersect(int[] A, int[] B) {
      Arrays.sort(A);
      Arrays.sort(B);

      int m = A.length;
      int n = B.length;
      int i = 0;
      int j = 0;

      List<Integer> res = new ArrayList<>();

      while (i < m && j < n) {
        if (A[i] == B[j]) {
          res.add(A[i]);
          i++; j++;
        } else if (A[i] > B[j]) j++;
        else i++;
      }

      int[] arr = new int[res.size()];
      int k = 0;
      for (Integer num : res) arr[k++] = num;
      return arr;
    }
  }
}