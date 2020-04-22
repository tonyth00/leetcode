
public class Solution134 {
  public static void main(String[] args) {
    int[] gas = {1, 2, 3, 4, 5};
    int[] cost = {3, 4, 5, 1, 2};
    System.out.println(new Solution().canCompleteCircuit(gas, cost));
  }

  static class Solution {
    /**
     * Intuition:
     * 1.) It's impossible to complete loop if totalGas < totalCost for the loop.
     * 2.) If A cannot reach C in the sequence A->B->C, then B cannot make it either.
     * Proof: 
     * A ------- B ------- C
     * 
     * Note that C is the first station that cannot be reached from A.
     * 
     * gasAB - costAB + gasBC - costBC < 0
     * gasAB + gasBC < costAB + costBC (1)
     * Chooose intermediary node B. If B is reachable starting at A, then
     * gasAB >= costAB (2)
     * Due to (2), we can subtract (2) from (1) and the following still holds:
     * gasBC < costBC
     * Therefore, any intermediary node cannot reach C either. We reset the starting point
     * to be immediately after C. Notice C cannot be a starting point either since it is
     * the first station to cause the total to be negative, so gas[C] - cost[C] < 0.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int total = 0;
      int n = gas.length;
      int start = 0;
      int cur = 0;
      for (int i = 0; i < n; i++) {
        total += gas[i] - cost[i];
        cur += gas[i] - cost[i];
        if (cur < 0) {
          start = i + 1;
          cur = 0;
        }
      }

      return total < 0 ? -1 : start;
    }
    /**
     * Brute force
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
      int n = gas.length;
      for (int i = 0; i < n; i++) {
        int sum = 0;
        boolean fail = false;
        for (int j = i; j < i + n; j++) {
          sum += gas[j % n] - cost[j % n];
          if (sum < 0) {
            fail = true;
            break;
          }
        }
        if (!fail) return i;
      }

      return -1;
    }
  }
}