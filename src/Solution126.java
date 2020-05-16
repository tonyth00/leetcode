import java.util.*;

class Solution126 {
  public static void main(String[] args) {
    // List<String> wordList =
    //     new ArrayList<>(Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
        List<String> wordList =
        new ArrayList<>(Arrays.asList("most","mist","miss","lost","fist","fish"));
        System.out.println(new Solution2().findLadders("lost", "miss", wordList));
  }

  static class Solution2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      List<List<String>> res = new ArrayList<>();
      Set<String> set = new HashSet<>(wordList); // O(nm)
      if (!set.contains(endWord)) return res;
      set.add(beginWord);

      Map<String, List<String>> adj = new HashMap<>();
      buildMap(set, adj);

      Deque<String> q = new ArrayDeque<>();
      q.add(beginWord);
      Map<String, Integer> levels = new HashMap<>();
      levels.put(beginWord, 0);

      while (!q.isEmpty()) { // O(v + e)
        String cur = q.remove();
        for (String v : adj.get(cur)) {
          if (!levels.containsKey(v)) {
            levels.put(v, levels.get(cur) + 1);
            if (v.equals(endWord)) { // O(m)
              q.clear();
              break;
            }
            q.add(v);
          }
        }
      }

      if (levels.get(endWord) == null) return res;
      LinkedList<String> curList = new LinkedList<>();
      curList.add(endWord);
      dfs(adj, levels, curList, levels.get(endWord), res);
      return res;
    }

    private void dfs(Map<String, List<String>> adj, Map<String, Integer> levels,
        LinkedList<String> curList, int curLevel, List<List<String>> res) {
      if (curLevel == 0) {
        res.add(new ArrayList<>(curList));
      } else {
        String cur = curList.get(0);
        for (String v : adj.get(cur)) {
          if (levels.getOrDefault(v, -1) == curLevel - 1) {
            curList.addFirst(v);
            dfs(adj, levels, curList, curLevel - 1, res);
            curList.removeFirst();
          }
        }
      }
    }

    // O(26nm^2)
    private void buildMap(Set<String> set, Map<String, List<String>> adj) {
      for (String s : set) { // O(n)
        char[] ch = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) { // O(m)
          char orig = ch[i];
          for (char c = 'a'; c <= 'z'; c++) { // O(26)
            if (c != orig) {
              ch[i] = c;
              String v = new String(ch); // O(m)
              if (set.contains(v)) list.add(v);  // O(m)
            }
          }
          ch[i] = orig;
        }
        adj.put(s, list);   
      }
    }
  }

  static class Solution {
    /**
     * Intuition:
     * - Use BFS to go from beginWord to endWord
     * - Use map to record the BFS level of each "node", which also records traversed nodes
     * - Use DFS starting at endWord, traverse towards beginWord, only following levels one level down from current node
     * until we reach beginWord. push result path to res.
     * 
     * O(nm^2 + n^2 * m^2) time, second term is for DFS but there's likely a tighter bound.
     * O(nm^2) space
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      int M = beginWord.length();
      wordList.add(beginWord);
      
      Map<String, Set<String>> map = new HashMap<>(); // O(nm^2) space
      buildMap(wordList, map);
      Map<String, Integer> level = new HashMap<>(); // O(nm) space
      level.put(beginWord, 0);
      Deque<String> q = new ArrayDeque<>(); // O(nm) space. consider level that has N - 2 nodes (exclude beginWord/endWord)
      q.add(beginWord);
      while (!q.isEmpty()) { // O(n)
        String cur = q.remove();
        for (int i = 0; i < M; i++) { // O(m)
          String key = cur.substring(0, i) + '*' + cur.substring(i + 1); // O(m)
          for (String v : map.getOrDefault(key, new HashSet<>())) {
            if (!level.containsKey(v)) {
              level.put(v, level.get(cur) + 1);
              if (v.equals(endWord)) break;
              q.add(v);
            }
          }
        }
      }
      List<List<String>> res = new ArrayList<>();
      if (level.get(endWord) == null) return res;
      LinkedList<String> cur = new LinkedList<>();
      cur.add(endWord);
      dfs(cur, level.get(endWord), map, level, res);
      return res;
    }

    // Time complexity: O(b^d) where b is average number of connections of a node, and d is shortest distance from endWord to beginWord.
    // In practice it is more efficient due to pruning: we only recursively call dfs on nodes along shortest paths.
    private void dfs(LinkedList<String> cur, int curLevel, Map<String, Set<String>> map, Map<String, Integer> level,
        List<List<String>> res) {
      if (curLevel == 0) {
        res.add(new ArrayList<>(cur));
      } else {
        String current = cur.get(0);
        for (int i = 0; i < current.length(); i++) { // O(m)
          String key = current.substring(0, i) + '*' + current.substring(i + 1); // O(m)
          for (String v : map.getOrDefault(key, new HashSet<>())) { // O(b) over all keys
            if (level.getOrDefault(v, -1) == curLevel - 1) {
              cur.addFirst(v);
              dfs(cur, curLevel - 1, map, level, res);
              cur.removeFirst();
            }
          }
        }
      }
    }

    // O(nm^2) time
    private void buildMap(List<String> wordList, Map<String, Set<String>> map) {
      int m = wordList.get(0).length();
      wordList.forEach(word -> { // O(n)
        for (int j = 0; j < m; j++) { // O(m)
          String key = word.substring(0, j) + '*' + word.substring(j + 1, m); // O(m)
          Set<String> list = map.getOrDefault(key, new HashSet<>());
          list.add(word); // O(m)
          map.put(key, list);
        }
      });
    }
  }
}
