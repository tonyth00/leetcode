public class Solution52 {
  public static void main(String[] args) {
    System.out.println(new Solution().totalNQueens(15));
  }

  static class Solution {
    public int totalNQueens(int n) {
      char[][] board = new char[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          board[i][j] = '.';
        }
      }
      int[] res = { 0 };
      helper(0, res, new boolean[2*n - 1], new boolean[2*n - 1], new boolean[n], board);
      return res[0];
    }

    private void helper(int y, int[] count, boolean[] d1, boolean[] d2, boolean[] col, char[][] board) {
      int n = board.length;
      if (y == n) {
        count[0]++;
      }

      for (int x = 0; x < n; x++) {
        if (col[x] || d1[x + y] || d2[n - 1 + x - y])
          continue;
        board[y][x] = 'Q';
        col[x] = d1[x + y] = d2[n - 1 + x - y] = true;
        helper(y + 1, count, d1, d2, col, board);
        board[y][x] = '.';
        col[x] = d1[x + y] = d2[n - 1 + x - y] = false;
      }

    }
  }
}