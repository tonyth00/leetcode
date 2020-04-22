
public class Solution36 {
  public static void main(String[] args) {
    char[][] board = {
      {'8','3','.','.','7','.','.','.','.'},
      {'6','.','.','1','9','5','.','.','.'},
      {'.','9','8','.','.','.','.','6','.'},
      {'8','.','.','.','6','.','.','.','3'},
      {'4','.','.','8','.','3','.','.','1'},
      {'7','.','.','.','2','.','.','.','6'},
      {'.','6','.','.','.','.','2','8','.'},
      {'.','.','.','4','1','9','.','.','5'},
      {'.','.','.','.','8','.','.','7','9'}
    };
    System.out.println(new Solution().isValidSudoku(board));
  }

  static class Solution {
    public boolean isValidSudoku(char[][] board) {
      int n = board.length;
      int rowSet = 0;
      int colSet = 0;
      int boxSet = 0;
      for (int i = 0; i < n; i++) {
        // check rows
        rowSet = 0;
        colSet = 0;
        boxSet = 0;
        
        for (int j = 0; j < n; j++) {
          if (board[i][j] == '.') continue;
          int flag = 1 << board[i][j] - '0';
          if ((rowSet & flag) != 0) return false;
          rowSet |= flag;
        }
        
        // check cols
        for (int j = 0; j < n; j++) {
          if (board[j][i] == '.') continue;
          int flag = 1 << board[i][j] - '0';
          if ((colSet & flag) != 0) return false;
          colSet |= flag;
        }

        // check box
        for (int j = 0; j < n; j++) {
          int a = i/3*3 + j/3;
          int b = i%3*3 + j%3;
          if (board[a][b] == '.') continue;
          int flag = 1 << board[i][j] - '0';
          if ((boxSet & flag) != 0) return false;
          boxSet |= 1 << flag;
        }
      }

      return true;
    }
  }
}
