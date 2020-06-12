import java.util.*;

public class Solution721 {
  public static void main(String[] args) {
    List<List<String>> accounts = new ArrayList<>();
    accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
    accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
    accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
    accounts.add(Arrays.asList("Mary", "mary@mail.com"));
    System.out.println(new Solution().accountsMerge(accounts));
  }

  static class Solution {
    /**
     * Intuition: 1.) Build a graph that merges all emails together as a connected component. Each
     * email acts as a node. Email nodes are unique: there cannot be two nodes with the same email.
     * Set up adjacency list, and for each account, link first email to the other emails.
     * Incidentally, if there are two duplicate emails between accounts, they will be "unioned"
     * together. A <-> B <-> C, B <-> D <-> F causes B to have adjacencies A, C, and D. 2.) At the
     * same time, map emails to names. It is guaranteed that each email uniquely maps to a name. 3.)
     * Use DFS to cluster all connected emails into a set - DFS all nodes until every node is
     * visited. 4.) The sorting of the emails comes from TreeSet
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      Map<String, Set<String>> adj = new HashMap<>();
      Map<String, String> emailToName = new HashMap<>();
      for (List<String> account : accounts) {
        String name = account.get(0);
        String email = account.get(1);
        for (int i = 1; i < account.size(); i++) {
          emailToName.put(account.get(i), name);
          adj.putIfAbsent(account.get(i), new HashSet<>());
          if (i == 1)
            continue;
          adj.get(email).add(account.get(i));
          adj.get(account.get(i)).add(email);
        }
      }

      List<List<String>> res = new ArrayList<>();
      Set<String> visited = new HashSet<>();
      for (String email : emailToName.keySet()) {
        if (visited.add(email)) {
          Set<String> cur = new TreeSet<>();
          dfs(adj, visited, cur, email);
          LinkedList<String> list = new LinkedList<>(cur);
          list.addFirst(emailToName.get(list.get(0)));
          res.add(list);
        }
      }
      return res;
    }

    private void dfs(Map<String, Set<String>> adj, Set<String> visited, Set<String> cur,
        String email) {
      cur.add(email);
      for (String v : adj.get(email)) {
        if (visited.add(v))
          dfs(adj, visited, cur, v);
      }
    }
  }
}
