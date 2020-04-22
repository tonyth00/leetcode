import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution118 {
  public static void main(String[] args) {
    System.out.println(new Solution().generate(5));
  }

  static class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> res = new ArrayList<>();

      for (int i = 0; i < numRows; i++) {
        if (i == 0) {
          res.add(Arrays.asList(1));
        } else {
          List<Integer> list = new ArrayList<>(res.get(i - 1));
          for (int j = list.size() - 1; j >= 1; j--) {
            list.set(j, list.get(j) + list.get(j - 1));
          }
          list.add(1);
          res.add(list);
        }
      }

      return res;
    }
  }
}
