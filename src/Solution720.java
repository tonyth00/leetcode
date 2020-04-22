import java.util.*;
public class Solution720 {
  public static void main(String[] args) {
    System.out.println(new Solution()
        .longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
  }

  static class Solution {
    public String longestWord(String[] words) {
      Set<String> set = new HashSet<>();
      for (String word: words) set.add(word);

      String res = "";
      for (int i = 0; i < words.length; i++) {
  
        String word = words[i];
        if (res.length() > word.length() || res.length() == word.length() && res.compareTo(word) < 0) continue;
        boolean good = true;
        for (int k = 1; k < word.length(); k++) {
          if (!set.contains(word.substring(0, k))) {
            good = false;
            break;
          }
        }
        if (good) res = word;
      }
      return res;
    }


    public String longestWord2(String[] words) {
      TrieNode root = new TrieNode();
      for (String word: words) root.insert(word);
      
      Arrays.sort(words, (a, b) -> {
        if (a.length() != b.length()) return Integer.compare(b.length(), a.length());
        else return a.compareTo(b);
      });

      for (String word: words) {
        if (root.hasAllPrefixes(word)) return word;
      }

      return null;
    }

    class TrieNode {
      TrieNode[] children = new TrieNode[26];
      boolean isWord = false;

      public void insert(String s) {
        TrieNode cur = this;
        for (int i = 0; i < s.length(); i++) {
          int c = s.charAt(i) - 'a';
          if (cur.children[c] == null) cur.children[c] = new TrieNode();
          cur = cur.children[c];
        }
        cur.isWord = true;
      }

      public boolean hasAllPrefixes(String word) {
        TrieNode cur = this;
        for (int i = 0; i < word.length(); i++) {
          int c = word.charAt(i) - 'a';
          if (!cur.children[c].isWord) return false;
          cur = cur.children[c];
        }
        return true;
      }
    }
  }
}
