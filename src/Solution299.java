/**
 * Solution299
 */
public class Solution299 {

  public static void main(String[] args) {
    System.out.println(new Solution().getHint("1123", "0111"));  
  }
  static class Solution {
    public String getHint(String secret, String guess) {
      int[] count = new int[10];
      int bulls = 0;
      int cows = 0;
      for (int i = 0; i < secret.length(); i++) {
        char s = secret.charAt(i);
        char g = guess.charAt(i);
        if (s == g) bulls++;
        else {
          if (count[s - '0'] < 0) cows++;
          if (count[g - '0'] > 0) cows++;
          count[s - '0']++;
          count[g - '0']--;
        } 
      }
      return bulls + "A" + cows + "B";
    }
  }
}