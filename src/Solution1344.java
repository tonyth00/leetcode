/**
 * Solution1344
 */
public class Solution1344 {

  public static void main(String[] args) {
    System.out.println(new Solution().angleClock(3, 30));
  }

  static class Solution {
    public double angleClock(int hour, int minutes) {
      double minutesAngle = minutes * 6;

      hour = hour % 12;
      double hourAngle =  (hour + minutesAngle / 360) * 30;

      double result = Math.abs(hourAngle - minutesAngle);
      if (result > 180) {
        result = 360 - result;
      }
      return result;

    }
  }
}