import java.util.ArrayList;
import java.util.List;

public class Solution51 {
  public static void main(String[] args) {
    System.out.println(new Solution().solveNQueens(4));
  }

  static class Solution {
    public List<List<String>> solveNQueens(int n) {
      List<List<String>> res = new ArrayList<>();
      char[][] board = new char[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          board[i][j] = '.';
        }
      }
      helper(0, res, n, new boolean[n + n], new boolean[n + n], new boolean[n], board);
      return res;
    }

    private void helper(int y, List<List<String>> res, int n, boolean[] diag1, boolean[] diag2,
        boolean[] col, char[][] board) {
      if (y == n) {
        res.add(construct(board));
      }

      for (int x = 0; x < n; x++) {
        if (col[x] || diag1[x + y] || diag2[n - 1 + x - y])
          continue;
        board[y][x] = 'Q';
        col[x] = diag1[x + y] = diag2[n - 1 + x - y] = true;
        helper(y+1, res, n, diag1, diag2, col, board);
        board[y][x] = '.';
        col[x] = diag1[x + y] = diag2[n - 1 + x - y] = false;
      }

    }

    private List<String> construct(char[][] b) {
      List<String> list = new ArrayList<>();
      for (int i = 0; i < b.length; i++) {
        list.add(new String(b[i]));
      }
      return list;
    }
  }
}