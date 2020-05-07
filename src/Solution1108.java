public class Solution1108 {
  public static void main(String[] args) {
    System.out.println(new Solution().defangIPaddr("255.100.50.0"));
  }

  static class Solution {
    public String defangIPaddr(String address) {
      char[] ch = new char[address.length() + 6];
      int k = 0;
      for (int i = 0; i < address.length(); i++) {
        char c = address.charAt(i);
        if (c == '.') {
          ch[k++] = '[';
          ch[k++] = '.';
          ch[k++] = ']';
        } else {
          ch[k++] = c;
        }
      }

      return new String(ch);
    }

    /**
     * Slow one liner
     */
    public String defangIPaddr2(String address) {
      return address.replace("\\.", "[.]");
    }
  }
}
