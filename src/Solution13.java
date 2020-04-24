
public class Solution13 {
  public static void main(String[] args) {
    System.out.println(new Solution().romanToInt("MCMXCIV"));
  }

  static class Solution {
    public int romanToInt(String s) {
      int[] map = new int[128];
      map['M'] = 1000;
      map['D'] = 500;
      map['C'] = 100;
      map['L'] = 50;
      map['X'] = 10;
      map['V'] = 5;
      map['I'] = 1;
      int sum = 0;
      char prev = '#';
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        sum += map[c];
        if (prev != '#' && map[prev] < map[c]) {
          sum -= map[prev] * 2;
        }
        prev = c;
      }
      return sum;
    }
  }
}
