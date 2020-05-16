import java.util.Arrays;
import shared.Helper;

public class Solution937 {
  public static void main(String[] args) {
    Helper.print(new Solution().reorderLogFiles(new String[] {"dig1 8 1 5 1", "let1 art can",
        "dig2 3 6", "let2 own kit dig", "let3 art zero"}));

  }

  static class Solution {
    public String[] reorderLogFiles(String[] logs) {
      int i = logs.length - 1;
      int j = logs.length - 1;
      while (j >= 0) {
        int index = logs[j].indexOf(' ') + 1;
        if (Character.isDigit(logs[j].charAt(index))) {
          swap(logs, i--, j);
        }
        j--;
      }

      Arrays.sort(logs, 0, i + 1, (a, b) -> {
        int indexA = a.indexOf(' ');
        int indexB = b.indexOf(' ');
        int compare = a.substring(indexA + 1).compareTo(b.substring(indexB + 1));
        if (compare == 0)
          return a.substring(0, indexA).compareTo(b.substring(0, indexB));
        return compare;
      });
      return logs;
    }

    private void swap(String[] logs, int i, int j) {
      String temp = logs[i];
      logs[i] = logs[j];
      logs[j] = temp;
    }
  }
}
