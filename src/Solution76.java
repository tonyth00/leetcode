/**
 * Solution76
 */
public class Solution76 {

  public static void main(String[] args) {
    System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
  }

  static class Solution {
    /**
     * Intuition:
     * Create a map holding the count of each character in String t.
     * Initialize two pointers, fast and slow. fast expands window, slow
     * contracts window. Expand window with fast pointer until all chars in t 
     * contained in window. Contract window with slow pointer until window 
     * becomes invalid, updating the min length during this phase.
     */
    public String minWindow(String s, String t) {
      if (s == null || t == null || s.length() < t.length()) return "";

      int count = t.length();
      int left = 0, right = 0;
      int minLeft = 0, minRight = s.length() + 1;
      int[] map = new int[128];
      for (char c : t.toCharArray()) map[c]++;

      while (right < s.length()) {
        char c = s.charAt(right);
        if (map[c] > 0) count--;
        map[c]--;
        right++;

        while (count == 0) {
          if (right - left < minRight - minLeft) {
            minRight = right;
            minLeft = left;
          }
          
          if (map[s.charAt(left)]++ == 0) count++;
          left++; 
        }
      }

      return minRight == s.length() + 1 ? "" : s.substring(minLeft, minRight);
    }
  }
}