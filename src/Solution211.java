/**
 * Solution211
 */
public class Solution211 {

  public static void main(String[] args) {
    WordDictionary obj = new WordDictionary();
    obj.addWord("bad");
    obj.addWord("dad");
    obj.addWord("mad");
    System.out.println(obj.search("pad"));
    System.out.println(obj.search("bad"));
    System.out.println(obj.search(".ad"));
    System.out.println(obj.search("b.."));
  }

  static class WordDictionary {
    class TrieNode {
      boolean isWord = false;
      TrieNode[] children = new TrieNode[26];
      char val;

      public TrieNode(char c) {
        val = c;
      }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
      root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null)
          cur.children[c - 'a'] = new TrieNode(c);
        cur = cur.children[c - 'a'];
      }
      cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
      return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] word, int start, TrieNode node) {
      if (node == null) return false;
      if (word.length == start) return node.isWord;
      
      char c = word[start];
      if (c == '.') {
        for (TrieNode n : node.children) {
          if (match(word, start + 1, n)) return true;
        }
        return false;
      } else {
        TrieNode n = node.children[c - 'a'];
        return match(word, start + 1, n);
      }
    }
  }
}