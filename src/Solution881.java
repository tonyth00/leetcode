import java.util.Arrays;

/**
 * Solution881
 */
public class Solution881 {

  public static void main(String[] args) {
    System.out.println(new Solution().numRescueBoats(new int[] {3, 2, 2, 1}, 3));
  }

  static class Solution {
    public int numRescueBoats(int[] people, int limit) {
      Arrays.sort(people);
      int i = 0;
      int j = people.length - 1;
      int numBoats = 0;
      while (i <= j) {
        if (people[i] + people[j] <= limit) {
          j--;
          i++;
        } else {
          j--;
        }

        numBoats++;
      }
      return numBoats;

    }
  }
}