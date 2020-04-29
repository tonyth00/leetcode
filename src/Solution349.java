import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import shared.Helper;

public class Solution349 {
  public static void main(String[] args) {
    Helper.print(new Solution().intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));
  }

  static class Solution {

    /**
     * Binary search
     * Time: x = min(m, n) => O(xlogx + ylogx) = O((x+y)logx)
     * Space: O(x)
     */
    public int[] intersection(int[] A, int[] B) {
      int m = A.length;
      int n = B.length;
      if (m > n) return intersection(B, A);
      Arrays.sort(A);

      Set<Integer> set = new HashSet<>(); // O(x) space
      for (int num : B) {
        if (binarySearch(A, num)) set.add(num);
      }
      int[] res = new int[set.size()];
      int i = 0;
      for (Integer num : set) res[i++] = num;

      return res;
    }

    private boolean binarySearch(int[] arr, int target) {
      int l = 0, r = arr.length;
      while (l < r) {
        int m = l + (r - l)/2;
        if (arr[m] == target) return true;
        else if (arr[m] > target) r = m;
        else l = m + 1;
      }

      return false;
    }


    /**
     * Sorted list two pointer solution
     * Time: O(nlogn + mlogm + n + m) = O(nlogn + mlogm)
     * Space: O(1)
     */
    public int[] intersection2(int[] A, int[] B) {
      Arrays.sort(A);
      Arrays.sort(B);

      int i = 0, j = 0;
      int m = A.length, n = B.length;
      List<Integer> res = new ArrayList<>();
      while (i < m && j < n) {
        if (A[i] == B[j]) {
          res.add(A[i]);
          i++; j++;
          while (i < m && A[i] == A[i - 1]) i++;
          while (j < n && B[j] == B[j - 1]) j++;
        } else if (A[i] < B[j]) i++;
        else j++;
      }
      
      int[] arr = new int[res.size()];
      for (int k = 0; k < res.size(); k++) arr[k] = res.get(k);
      return arr;
    }

    /**
     * Trivial solution using two sets
     * O(m + n) time/space
     * You could compress space to O(min(m, n)) if you choose to compare
     * the two array's lengths and take the shorter one.
     */
    public int[] intersection3(int[] A, int[] B) {
      Set<Integer> set = new HashSet<>();
      for (int num : A) set.add(num);

      Set<Integer> intersect = new HashSet<>();
      for (int num : B) {
        if (set.contains(num)) {
          intersect.add(num);
        }
      }

      int[] arr = new int[intersect.size()];
      int i = 0;
      for (Integer v : intersect) arr[i++] = v;

      return arr;
    }
  }
}