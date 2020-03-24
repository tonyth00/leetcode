import java.util.ArrayList;
import java.util.List;

/**
 * Solution212
 */
public class Solution212 {

  public static void main(String[] args) {
    char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };

    String[] words = { "oath", "pea", "eat", "rain" };

    System.out.println(new Solution().findWords(board, words));
  }

  static class Solution {
    public List<String> findWords(char[][] board, String[] words) {
      List<String> res = new ArrayList<>();
      if (board == null || board.length == 0 || board[0].length == 0)
        return res;
      int m = board.length;
      int n = board[0].length;

      TrieNode root = new TrieNode();
      for (String word : words) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
          char c = word.charAt(i);
          if (cur.children[c - 'a'] == null)
            cur.children[c - 'a'] = new TrieNode();
          cur = cur.children[c - 'a'];
        }
        cur.word = word;
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          search(board, i, j, root, res);
        }
      }

      return res;
    }

    private void search(char[][] board, int i, int j, TrieNode node, List<String> res) {
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#')
        return;

      char c = board[i][j];
      node = node.children[c - 'a'];
      if (node == null) {
        return;
      }

      if (node.word != null) {
        res.add(node.word);
        node.word = null;
      }

      board[i][j] = '#';
      search(board, i - 1, j, node, res);
      search(board, i + 1, j, node, res);
      search(board, i, j - 1, node, res);
      search(board, i, j + 1, node, res);
      board[i][j] = c;
    }

    class TrieNode {
      String word = null;
      TrieNode[] children = new TrieNode[26];
    }
  }
}