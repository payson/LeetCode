package mySolutions;

/**
 * Created by Payson Wu on 16/03/14.
 *
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = x < 0 ? true : false;
        x = Math.abs(x);
        int result = x % 10;
        while (x / 10 > 0) {
            x /= 10;
            result *= 10;
            result += x % 10;
        }
        return isNegative? -result : result;
    }
}
