
public class Solution836 {
  public static void main(String[] args) {
    int[] rect1 = {0, 0, 2, 2};
    int[] rect2 = {1, 1, 3, 3};
    System.out.println(new Solution().isRectangleOverlap(rect1, rect2));
  }

  static class Solution {
    /**
     * Two 1D segments
     * r1.left ---------------------- r1.right
     *               r2.left -------------------------r2.right
     * Two segments overlap if r1.left < r2.right AND r2.left < r1.right. This holds
     * even if r2 is before r1. This is similar to Meeting Interval problem.
     * 
     * For rectangles, we reduce each rectangle to one horizontal (left, right) segment and one vertical (top, bottom) segment
     * Two rectangles overlap if their horizontal segments overlap and vertical segments overlap
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
      Rect r1 = new Rect(rec1);
      Rect r2 = new Rect(rec2);
      return r1.left < r2.right && r2.left < r1.right && r1.bottom < r2.top && r2.bottom < r1.top;
    }

    /**
     * Alternatively, we test conditions for no overlap. If the right bounds of one rectangle is less
     * than the left bounds of the other rectangle, it's impossible to overlap and we return false.
     * Similarly, if the top bounds of one rectangle is less than the bottom bounds of other other,
     * it's impossible to overlap.
     */
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {

      Rect r1 = new Rect(rec1);
      Rect r2 = new Rect(rec2);

      if (r1.right <= r2.left || r2.right <= r1.left || r1.top <= r2.bottom || r2.top <= r1.bottom) return false;
      return true;

    }

    /**
     * Yet another solution is we calculate the width, and height of the overlap
     */
    public boolean isRectangleOverlap3(int[] rec1, int[] rec2) {
      Rect r1 = new Rect(rec1);
      Rect r2 = new Rect(rec2);

      int width = Math.min(r1.right, r2.right) - Math.max(r1.left, r2.left);
      int height = Math.min(r2.top, r1.top) - Math.max(r2.bottom, r1.bottom);

      return width > 0 && height > 0;
    }

    // put in object to make easier to visualize
    class Rect {
      public int top, right, bottom, left;
      public Rect(int[] arr) {
        this.top = arr[3];
        this.right = arr[2];
        this.bottom = arr[1];
        this.left = arr[0];
      }
    }
  }
}