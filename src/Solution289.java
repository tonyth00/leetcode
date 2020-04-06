import shared.Helper;
public class Solution289 {
  public static void main(String[] args) {
    int[][] board = new int[][] {
      {0,1,0},
      {0,0,1},
      {1,1,1},
      {0,0,0}
    };
    new Solution().gameOfLife(board);
    Helper.print(board);
  }

  static class Solution {
    final int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    public void gameOfLife(int[][] board) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          update(board, i, j);
        }
      }
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          board[i][j] >>= 1;
        }
      }
    }
    private void update(int[][] board, int i, int j) {
      int count = 0;
      for (int[] dir : dirs) {
        count += count(board, i + dir[0], j + dir[1]);
      }
      
      if ((board[i][j] & 1) == 0 && count == 3) {
        board[i][j] |= 0b10;
      } else if (board[i][j] == 1 && count >= 2 && count <= 3) {
        board[i][j] |= 0b10;
      }
    }
    private int count(int[][] board, int i, int j) {
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || (board[i][j] & 1) == 0) return 0;
      return 1;
    };
  }
}