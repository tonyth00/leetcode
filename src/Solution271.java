import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution271
 */
public class Solution271 {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>(Arrays.asList("HELLO", "BJFDOJS", "FDJSKLFJS"));
    Codec codec = new Codec();
    System.out.println(codec.decode(codec.encode(list)));
  }

  static class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
      StringBuilder sb = new StringBuilder();
      for (String str : strs) {
        sb.append(str.length()).append('/').append(str);
      }
      return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
      List<String> list = new ArrayList<>();

      int i = 0;
      while (i < s.length()) {
        int slash = s.indexOf('/', i);
        int length = Integer.parseInt(s.substring(i, slash));
        i = slash + length + 1;
        list.add(s.substring(slash + 1, i));
      }

      return list;
    }
  }
}