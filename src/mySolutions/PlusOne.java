package mySolutions;

import java.util.Arrays;

/**
 * Created by Payson Wu on 16/03/14.
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int[] result = new int[digits.length+1];
        for (int i = digits.length-1; i>= 0; i--) {
            int temp = carry + digits[i];
            carry = temp / 10;
            temp %= 10;
            result[i+1] = temp;
        }
        if (carry > 0) {
            result[0] = carry;
            return result;
        }
        return Arrays.copyOfRange(result, 1, result.length);
    }
}
