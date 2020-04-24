import shared.Helper;

public class Solution37 {
  public static void main(String[] args) {
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    new Solution().solveSudoku(board);
    Helper.print(board);
  }

  static class Solution {
    char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int[] rowSet = new int[9];
    int[] colSet = new int[9];
    int[] boxSet = new int[9];
    public void solveSudoku(char[][] board) {
      fillSet(board, rowSet, colSet, boxSet);
      dfs(board, 0, 0);
    }

    private void fillSet(char[][] board, int[] rowSet, int[] colSet, int[] boxSet) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (board[i][j] == '.') continue;
          int flag = 1 << board[i][j] - '0';
          rowSet[i] |= flag;
          colSet[j] |= flag;
          boxSet[i/3*3 + j/3] |= flag;
        }
      }
    }

    private boolean dfs(char[][] board, int i, int j) {
      // System.out.println(i + " " + j);
      if (i == 9)
        return true;
      if (board[i][j] != '.') {
        return dfs(board, i + (j + 1) / 9, (j + 1) % 9);
      }

      for (char c : nums) {
        int flag = 1 << (c - '0');
        if (isValid(flag, i, j, rowSet, colSet, boxSet)) {
          board[i][j] = c;
          rowSet[i] |= flag;
          colSet[j] |= flag;
          boxSet[i/3*3 + j/3] |= flag;

          if (dfs(board, i + (j + 1) / 9, (j + 1) % 9)) return true;

          rowSet[i] ^= flag;
          colSet[j] ^= flag;
          boxSet[i/3*3 + j/3] ^= flag;
          board[i][j] = '.';
        }
        // System.out.println(c);
      }
      return false;
    }

    private boolean isValid(int v, int i, int j, int[] rowSet, int[] colSet, int[] boxSet) {
      if ((rowSet[i] & v) > 0 || (colSet[j] & v) > 0 || (boxSet[i/3*3 + j/3] & v) > 0) return false;
      return true;
    }

    /**
     * This takes O(27) per check, which is the main bottleneck here.
     */
    private boolean isValid2(char[][] board, int i, int j, char c) {
      for (int k = 0; k < 9; k++) {
        if (board[k][j] == c) return false;
        if (board[i][k] == c) return false;
        if (board[i/3*3 + k/3][j/3*3 + k%3] == c) return false;
      }
      return true;
    }
  }
}
