import java.util.Map;
import java.util.HashMap;

public class Solution911 {
  public static void main(String[] args) {
    int[] persons = {0, 1, 1, 0, 0, 1, 0};
    int[] times = {0, 5, 10, 15, 20, 25, 30};
    TopVotedCandidate c = new TopVotedCandidate(persons, times);
    System.out.println(c.q(3));
    System.out.println(c.q(12));
    System.out.println(c.q(25));
    System.out.println(c.q(15));
    System.out.println(c.q(24));
    System.out.println(c.q(8));
  }

  static class TopVotedCandidate {

    int[] leader;
    int[] times;

    /**
     * Intuition:
     * - The only time when the leading vote changes is when someone casts a vote.
     * Therefore, it could happen at any point along times[0] -> times[n - 1]
     * Create an array that stores the current leader whenever someone votes.
     * leader[i] = leader at time[i]
     * We keep count of the votes using a map. Then when someone casts a vote, 
     * increment map count and update current leader.
     * 
     * - To obtain the current leader at any point in time, binary search the times
     * array for a time[i] <= t (floor). Then get the leader[i].
     */
    public TopVotedCandidate(int[] persons, int[] times) {
      Map<Integer, Integer> map = new HashMap<>();
      int leading = persons[0];
      int n = persons.length;
      leader = new int[n];
      for (int i = 0; i < n; i++) {
        map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
        if (map.get(leading) <= map.get(persons[i])) leading = persons[i];
        leader[i] = leading;
      }
      this.times = times;
    }

    public int q(int t) {
      int l = 0, r = times.length;
      while (l < r) {
        int m = l + (r - l)/2;
        if (times[m] > t) r = m;
        else l = m + 1; 
      }

      return leader[l - 1];
    }
  }
}
