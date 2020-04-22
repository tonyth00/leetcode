import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution170 {
  public static void main(String[] args) {

  }

  static class TwoSum {
    List<Integer> list;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
      map = new HashMap<>();
      list = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
      map.put(number, map.getOrDefault(number, 0) + 1);
      list.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
      for (Integer num1 : list) {
        int num2 = value - num1;
        if (map.containsKey(num2)) {
          if (num1 != num2 || map.get(num2) > 1) return true;
        }
      }
      return false;
    }
  }
}
