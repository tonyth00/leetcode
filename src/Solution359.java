import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution359 {
  public static void main(String[] args) {
    
  }


  static class Logger {
    Queue<Log> queue = new LinkedList<>();
    Set<String> set = new HashSet<>();
    public Logger() {}

    public boolean shouldPrintMessage(int timestamp, String message) {
      if (!queue.isEmpty() && timestamp >= queue.peek().timestamp + 10) {
        // safely delete logs
        set.remove(queue.remove().message);
      }
      if (set.contains(message)) return false;
      set.add(message);
      queue.add(new Log(message, timestamp));
      return true;
    }

    class Log {
      public String message;
      public int timestamp;
      public Log(String message, int timestamp) {
        this.message = message;
        this.timestamp = timestamp;
      }
    }
  }


  // naive solution, O(1) time, space never stops growing
  static class Logger2 {
    Map<String, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public Logger2() {
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
      if (!map.containsKey(message) || timestamp >= map.get(message) + 10) {
        map.put(message, timestamp);
        return true;
      } else {
        return false;
      }
    }
  }
}