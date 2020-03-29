import java.util.*;

class Solution929 {
  public static void main(String[] args) {
    System.out.println(new Solution().numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
  }

  static class Solution {
    public int numUniqueEmails(String[] emails) {
      Set<String> set = new HashSet<>();
      for (String email : emails) {
        StringBuilder sb = new StringBuilder();
        int atIndex = email.indexOf('@');
        for (int i = 0; i < atIndex; i++) {
          char c = email.charAt(i);
          if (c == '.') continue;
          if (c == '+') break;
          sb.append(c);
        }
        sb.append(email.substring(atIndex));
        set.add(sb.toString());
      }
      return set.size();
    }
  }
}