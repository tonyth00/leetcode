import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Solution729
 */
public class Solution729 {

  public static void main(String[] args) {
    MyCalendar myCalendar = new MyCalendar();
    System.out.println(myCalendar.book(10, 20));
    System.out.println(myCalendar.book(15, 25));
    System.out.println(myCalendar.book(20, 30));
  }

  static class MyCalendar {
    List<int[]> intervals = new ArrayList<>();
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendar() {
      
    }

    public boolean book(int start, int end) {
      Map.Entry<Integer, Integer> prev = map.floorEntry(start);
      if (prev != null && start < prev.getValue()) return false;
      Map.Entry<Integer, Integer> next = map.ceilingEntry(start);
      if (next != null && next.getKey() < end) return false;

      map.put(start, end);
      return true;
    }
    
    // brute force
    public boolean book2(int start, int end) {
      for (int[] interval : intervals) {
        if (Math.max(start, interval[0]) < Math.max(end, interval[1])) return false;
      }
      intervals.add(new int[] {start ,end});
      return true;
    }
  }
}