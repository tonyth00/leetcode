package sort;

import shared.Helper;

public class Sort {
  public static void main(String[] args) {
    int[] nums = { 4, 2, 1, 5, 6, 5, 3, 3, 7, 7, 4, 2 };
    // bubbleSort(arr);
    mergeSort(nums, 0, nums.length);
    Helper.print(nums);
  }

  static void bubbleSort(int[] nums) {
    int n = nums.length;
    for (int lastIndex = n - 1; lastIndex >= 0; lastIndex--) {
      boolean swapped = false;
      for (int j = 0; j < lastIndex; j++) {
        if (nums[j] > nums[j + 1]) {
          swapped = true;
          swap(nums, j, j + 1);
        }
      }
      if (!swapped)
        return;
    }
  }

  static void mergeSort(int[] nums, int start, int end) {
    if (end - start < 2)
      return;

    int mid = start + (end - start) / 2;
    mergeSort(nums, start, mid);
    mergeSort(nums, mid, end);

    merge(nums, start, mid, end);

  }

  static void merge(int[] nums, int start, int mid, int end) {
    if (nums[mid - 1] <= nums[mid]) return; // sorted
    int i = start;
    int j = mid;

    int[] temp = new int[end - start];
    int k = 0;
    while (i < mid && j < end) {
      temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
    }
    while (i < mid) temp[k++] = nums[i++];
    while (j < end) temp[k++] = nums[j++];
    
    System.arraycopy(temp, 0, nums, start, temp.length);
  }

  static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}