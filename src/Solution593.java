import java.util.Arrays;
import shared.Helper;

public class Solution593 {
  public static void main(String[] args) {
    System.out.println(new Solution().validSquare(new int[] {2, 1}, new int[] {4, 2}, new int[] {3, 4}, new int[] {1, 3}));
  }

  static class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
      int[] dists = {d(p1, p2), d(p1, p3), d(p1, p4), d(p2, p3), d(p2, p4), d(p3, p4)};
      Arrays.sort(dists);
      Helper.print(dists);
      for (int i = 0; i < 3; i++) {
        if (dists[i] != dists[i + 1]) return false;
      }
      if (dists[4] != dists[5]) return false;
      
      return dists[4] > dists[3];
    }

    private int d(int[] a, int[] b) {
      return (a[0] - b[0])*(a[0] - b[0]) + (a[1] - b[1])*(a[1] - b[1]);
    }
  }
}