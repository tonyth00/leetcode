class Solution844 {
  public static void main(String[] args) {
    System.out.println(new Solution().backspaceCompare("xywrrmp", "xywrrmu#p"));
  }

  static class Solution {
    public boolean backspaceCompare(String S, String T) {
      int i = S.length() - 1;
      int j = T.length() - 1;
      while (true) {
        for (int numHashes = 0; i >= 0; i--) {
          numHashes += S.charAt(i) == '#' ? 1 : -1;
          if (numHashes < 0)
            break;
        }
        for (int numHashes = 0; j >= 0; j--) {
          numHashes += T.charAt(j) == '#' ? 1 : -1;
          if (numHashes < 0)
            break;
        }

        if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
          i--;
          j--;
        } else {
          return i == -1 && j == -1;
        }
      }
    }
  }
}