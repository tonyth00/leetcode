import java.util.*;
import shared.*;

class Solution973 {
  public static void main(String[] args) {
    Helper.print(new Solution().kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2));
  }

  static class Solution {
    /**
     * Intuition:
     * Use quicksort to randomly guess a pivot. If guess is correct, we're done.
     * Otherwise, on average, decrease the search space by half => n + 1/2n + 1/4n + 1/8n => O(n)
     */
    public int[][] kClosest(int[][] points, int K) {

      int start = 0;
      int end = points.length - 1;

      Random rand = new Random();
      while (start <= end) {
        int pivotIndex = partition(points, start, end, start + rand.nextInt(end - start + 1));
        if (pivotIndex == K - 1) {
          break;
        } else if (pivotIndex > K - 1) {
          end = pivotIndex - 1;
        } else {
          start = pivotIndex + 1;
        }
      }

      return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] points, int start, int end, int pivotIndex) {
      swap(points, end, pivotIndex); // move element to pivot to the end
      int[] pivot = points[end];
      int i = start;
      for (int j = start; j < end; j++) {
        if (dist(points[j]) < dist(pivot)) swap(points, j, i++);
      }
      swap(points, i, end);
      return i;
    }

    private int dist(int[] p) {
      return p[0]*p[0] + p[1]*p[1];
    }

    private void swap(int[][] points, int i, int j) {
      int[] temp = points[i];
      points[i] = points[j];
      points[j] = temp;
    }
  }
}