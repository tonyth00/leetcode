/**
 * Solution79
 */
public class Solution79 {

  public static void main(String[] args) {
    char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

    System.out.println(new Solution().exist(board, "ABCB"));
  }

  static class Solution {
    public boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
          if (board[i][j] == word.charAt(0)) {
            boolean res = helper(board, word, i, j, 0);
            if (res)
              return true;
          }
        }
      }
      return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index) {
      if (index == word.length())
        return true;

      if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == word.charAt(index)) {
        board[i][j] = '#';

        boolean res = helper(board, word, i - 1, j, index + 1) || helper(board, word, i + 1, j, index + 1)
            || helper(board, word, i, j - 1, index + 1) || helper(board, word, i, j + 1, index + 1);
        if (res) return true;
        board[i][j] = word.charAt(index);
      }

      return false;

    }
  }
}