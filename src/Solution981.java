import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution981 {
  public static void main(String[] args) {

  }

  static class TimeMap {
    Map<String, List<Entry>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(new Entry(value, timestamp));
    }

    public String get(String key, int timestamp) {
      if (!map.containsKey(key))  return "";
        List<Entry> list = map.get(key);
        
        for (int i = list.size()- 1; i >= 0 ; i--){
            if (list.get(i).timestamp <= timestamp) return list.get(i).value;
        }
        
        return "";
    }

    class Entry {
      int timestamp;
      String value;
      public Entry(String value, int timestamp) {
        this.timestamp = timestamp;
        this.value = value;
      }
    }
  }
}
