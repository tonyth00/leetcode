import shared.Helper;
public class Solution723 {
  public static void main(String[] args) {
    int[][] board = {
     {110,5,112,113,114},
     {210,211,5,213,214},
     {310,311,3,313,314},
     {410,411,412,5,414},
     {5,1,512,3,3},
     {610,4,1,613,614},
     {710,1,2,713,714},
     {810,1,2,1,1},
     {1,1,2,2,2},
     {4,1,4,4,1014}
    };
    Helper.print(new Solution().candyCrush(board));
  }

  static class Solution {
    public int[][] candyCrush(int[][] g) {
      if (g == null || g.length == 0 || g[0].length == 0) return g;

      boolean isStable = true;
      int m = g.length;
      int n = g[0].length;
      // mark horizontal
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n - 2; j++) {
          int v = Math.abs(g[i][j]);
          if (v > 0 && v == Math.abs(g[i][j + 1]) && v == Math.abs(g[i][j + 2])) {
            g[i][j] = g[i][j + 1] = g[i][j + 2] = -v;
            isStable = false;
          } 
        }
      }
      // mark vertical
      for (int j = 0; j < n; j++) {
        for (int i = 0; i < m - 2; i++) {
          int v = Math.abs(g[i][j]);
          if (v > 0 && v == Math.abs(g[i + 1][j]) && v == Math.abs(g[i + 2][j])) {
            g[i][j] = g[i + 1][j] = g[i + 2][j] = -v;
            isStable = false;
          }
            
        }
      }
      if (!isStable) {
        for (int j = 0; j < n; j++) {
          int k = m - 1;
          for (int i = m - 1; i >= 0; i--) {
            if (g[i][j] > 0) g[k--][j] = g[i][j];
            else if (g[i][j] == 0) break;
          }
          while (k >= 0) {
            g[k--][j] = 0;
          }
        }
      }

      return isStable ? g : candyCrush(g);
    }
  }
}
