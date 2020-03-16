import shared.Helper;

/**
 * Solution189
 */
public class Solution189 {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
    new Solution().rotate(arr, 3);
    Helper.print(arr);
  }

  static class Solution {
    public void rotate(int[] nums, int k) {
      k = k % nums.length;
      
    }
  }
}