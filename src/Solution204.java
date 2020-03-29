class Solution204 {
  public static void main(String[] args) {
    System.out.println(new Solution().countPrimes(3));
  }

  static class Solution {
    public int countPrimes(int n) {
      boolean[] notPrime = new boolean[n];
      int count = 0;
      for (int i = 2; i * i < n; i++) {
        if (!notPrime[i]) { // prime
          for (int j = i; i * j < n; j++) {
            notPrime[i * j] = true;
          }
        }
      }
      for (int i = 2; i < n; i++) { // O(n)
        if (!notPrime[i]) count++;
      }
      return count;
    }
  }
}