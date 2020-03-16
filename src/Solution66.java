
public class Solution66 {
  public static void main(String[] args) {
    int[] result = plusOne(new int[] { 9, 9, 9, 9 });
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
  }

  public static int[] plusOne(int[] digits) {
    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int[] newNum = new int[n + 1];
    newNum[0] = 1;
    return newNum;
  }
}