
public class Solution794 {
  public static void main(String[] args) {
    String[] board = {"XXX", "OOX", "OOX"};
    System.out.println(new Solution().validTicTacToe(board));
  }

  static class Solution {
    public boolean validTicTacToe(String[] board) {
      char[][] b = new char[3][3];
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          b[i][j] = board[i].charAt(j);
        }
      }
      int countX = 0;
      int countO = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (b[i][j] == 'X') countX++;
          else if (b[i][j] == 'O') countO++; 
        }
      }

      if (countO > countX) return false;
      if (countX - countO > 1) return false;
      boolean winX = win(b, 'X');
      boolean winO = win(b, 'O');
      if (winX && winO) return false;
      if (winX && countX != countO + 1) return false;
      if (winO && countO != countX) return false;

      return true;
    }

    private boolean win(char[][] b, char c) {
      for (int i = 0; i < 3; i++) {
        if (c == b[i][0] && c == b[i][1] && c == b[i][2]) return true;
        if (c == b[0][i] && c == b[1][i] && c == b[2][i]) return true; 
      }
      if (c == b[0][0] && c == b[1][1] && c == b[2][2]) return true;
      if (c == b[0][2] && c == b[1][1] && c == b[2][0]) return true;
      return false;
    }
  }
}