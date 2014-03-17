package mySolutions;

/**
 * Created by Payson Wu on 16/03/14.
 *
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 */

public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = 0;
        for (int a : A)
            result ^= a;
        return result;
    }
}
