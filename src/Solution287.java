import java.util.HashSet;

/**
 * Solution287
 */
public class Solution287 {

  public static void main(String[] args) {
    System.out.println(new Solution().findDuplicate(new int[] {1, 3, 4, 2, 2}));
  }
  static class Solution {
    /**
     * Intuition: Floyd's Tortoise and Hare Cycle Detection.
     * This is one of those "You either know it or you don't algorithms".
     * Due to the pigeonhole principle: given numbers 1, ..., n and n + 1 size array,
     * there must be a duplicate in the array.
     * Treat each element as a node in a LinkedList. Given an array [1, 3, 4, 2, 2]:
     * nums[0] points to 1 (first node), nums[1] points to 3 (second node).
     * We end up with: 1->3->2->4
     *                       ^  |
     *                       |__|
     * In this case, a cycle is inevitable due to pigeonhole principle. Set fast/slow at first node (nums[0])
     * increment fast twice as fast as slow until they meet. Then set slow to first node, iterate both fast
     * and slow one element at a time until they meet. Meeting point is duplicate.
     * 
     * Complexity: O(n) time, O(1) space.
     */
    public int findDuplicate(int[] nums) {
      int slow = nums[0], fast = nums[0];
      do {
        slow = nums[slow];
        fast = nums[nums[fast]];
      } while (slow != fast);

      slow = nums[0];
      while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
      }

      return slow;
    }


    /**
     * Use a set: O(n) space
     */
    public int findDuplicate2(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
        if (!set.contains(nums[i])) {
          set.add(nums[i]);
        } else {
          return nums[i];
        }
      }
      return -1;
    }
  }
}
