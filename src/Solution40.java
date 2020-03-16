import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import shared.Helper;

/**
 * Solution40
 */
public class Solution40 {

  public static void main(String[] args) {
    System.out.println(new Solution().combinationSum2(new int[] { 2,5,2,1,2 }, 5));
  }

  static class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(candidates);
      Helper.print(candidates);
      backtrack(candidates, target, new ArrayList<>(), res, 0);
      return res;
    }

    public void backtrack(int[] candidates, int remaining, List<Integer> combination, List<List<Integer>> res,
        int start) {
      if (remaining < 0) {
        return;
      } else if (remaining == 0) {
        res.add(new ArrayList<>(combination));
      } else {
        for (int i = start; i < candidates.length; i++) {
          combination.add(candidates[i]);
          backtrack(candidates, remaining - candidates[i], combination, res, i + 1);
          combination.remove(combination.size() - 1);

          while (i < candidates.length - 1 && candidates[i] == candidates[i+1]) i++;
        }
      }
    }

  }
}