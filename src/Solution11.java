/**
 * Solution11
 */
public class Solution11 {

  public static void main(String[] args) {
    System.out.println(new Solution().maxArea(new int[] { 2, 1, 3, 4 }));
  }

  static class Solution {
    public int maxArea(int[] height) {
      if (height.length <= 1) return 0;
      int left = 0;
      int right = height.length - 1;

      int maxArea = 0;
      while (left < right) {
        maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
        if (height[left] < height[right]) {
          left++;
        } else {
          right--;
        }
      }

      return maxArea;
    }
  }
}