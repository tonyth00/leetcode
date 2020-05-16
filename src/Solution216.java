import java.util.List;
import java.util.ArrayList;
public class Solution216 {
  public static void main(String[] args) {
    System.out.println(new Solution().combinationSum3(3, 9));
  }

  static class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> res = new ArrayList<>();
      backtrack(new ArrayList<>(), res, k, n);
      return res;
    }

    private void backtrack(List<Integer> cur, List<List<Integer>> res, int k, int remaining) {
      if (remaining < 0) return;
      if (cur.size() == k && remaining == 0) {
        res.add(new ArrayList<>(cur));
      } else {
        int start = cur.isEmpty() ? 1 : cur.get(cur.size() - 1) + 1;
        for (int i = start; i <= 9; i++) {
          cur.add(i);
          backtrack(cur, res, k, remaining - i);
          cur.remove(cur.size() - 1);
        }
      }
    }
  }
}
