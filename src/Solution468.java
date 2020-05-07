public class Solution468 {
  public static void main(String[] args) {
    System.out.println(new Solution().validIPAddress("172.16.254.1"));
    System.out.println(new Solution().validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334:"));
  }

  static class Solution {
    public String validIPAddress(String IP) {
      if (isValidIPv4(IP)) return "IPv4";
      if (isValidIPv6(IP)) return "IPv6";
      return "Neither";
    }

    private boolean isValidIPv6(String IP) {
      if (IP.startsWith(":") || IP.endsWith(":")) return false;
      String[] tokens = IP.split(":");
      if (tokens.length != 8) return false;
      for (String token : tokens) {
        if (!token.matches("[\\da-fA-F]{1,4}")) return false;
      }

      return true;
    }

    private boolean isValidIPv4(String IP) {
      if (IP.startsWith(".") || IP.endsWith(".")) return false;
      String[] tokens = IP.split("\\.");
      if (tokens.length != 4) return false;
      for (String token : tokens) {
        if (token.length() == 0) return false;
        if (token.charAt(0) == '0' && token.length() > 1) return false;
        int num = 0;
        for (char c : token.toCharArray()) {
          if (Character.isDigit(c))
            num = num * 10 + c - '0';
          else return false;
          if (num > 256) return false;
        }
        if (num > 255) return false;
      }
      return true;
    }
  }
}
