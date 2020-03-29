import java.util.Random;
class Solution215 {
  public static void main(String[] args) {
    System.out.println(new Solution().findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
  }

  static class Solution {
    public int findKthLargest(int[] nums, int k) {
      Random rand = new Random();
      k = nums.length - k;
      int start = 0;
      int end = nums.length - 1;
      while (start < end) {
        int pivotIndex = start + rand.nextInt(end - start + 1);
        int index = partition(nums, start, end, pivotIndex);
        if (index == k) {
          break;
        } else if (index < k) {
          start = index + 1;
        } else {
          end = index - 1;
        }
      }
      return nums[k];
    }

    private int partition(int[] nums, int start, int end, int pivotIndex) {
      int pivot = nums[pivotIndex];
      swap(nums, pivotIndex, end);
      
      int i = start;
      for (int j = start; j < end; j++) {
        if (nums[j] < pivot) swap(nums, i++, j);
      }
      swap(nums, i, end);
      return i;
    }
    private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
}