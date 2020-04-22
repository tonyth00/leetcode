import java.util.List;
import java.util.ArrayList;
public class Solution119 {
  public static void main(String[] args) {
    System.out.println(new Solution().getRow(3));
  }

  static class Solution {
    public List<Integer> getRow(int rowIndex) {
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i <= rowIndex; i++) {
        for (int j = res.size() - 1; j >= 1; j--) {
          res.set(j, res.get(j) + res.get(j - 1));
        }
        res.add(1);
      }

      return res;
    }
  }
}