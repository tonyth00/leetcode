
public class Solution278 {
  public static void main(String[] args) {

  }

  static class Solution extends VersionControl {
    public int firstBadVersion(int n) {
      int l = 1, r = n;
      while (l < r) {
        int m = l + (r - l)/2;
        if (isBadVersion(m)) r = m;
        else l = m + 1;
      }
      return l;
    }
  }

  static class VersionControl {
    boolean isBadVersion(int version) {
      return version >= 4;
    }
  }
}
