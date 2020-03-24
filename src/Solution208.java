/**
 * Solution208
 */
public class Solution208 {

  public static void main(String[] args) {

    Trie obj = new Trie();
    obj.insert("apple");
    System.out.println(obj.search("apple"));
    System.out.println(obj.startsWith("app"));

  }

  static class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
      root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.children[c - 'a'] == null) {
          cur.children[c - 'a'] = new TrieNode(c);
        }
        cur = cur.children[c - 'a'];
      }
      cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      TrieNode cur = root;
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        cur = cur.children[c - 'a'];
        if (cur == null)
          return false;
      }
      return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
      TrieNode cur = root;
      for (int i = 0; i < prefix.length(); i++) {
        char c = prefix.charAt(i);
        cur = cur.children[c - 'a'];
        if (cur == null)
          return false;
      }
      return true;
    }

    class TrieNode {
      char val;
      TrieNode[] children = new TrieNode[26];
      boolean isWord = false;

      public TrieNode(char c) {
        val = c;
      }
    }
  }

}