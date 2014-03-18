package mySolutions;

import java.util.HashMap;
/**
 * Created by Payson Wu on 17/03/14.
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (hm.containsKey(numbers[i]) && target == 2 * numbers[i]) { // if hm contains the number before, it matters iff target = 2 * numbers[i]
                index1 = hm.get(numbers[i]);
                index2 = i + 1; // i + 1 since not zero based
                break;
            }
            hm.put(numbers[i], i + 1);
            if (hm.containsKey(target - numbers[i]) && target != 2 * numbers[i]) {
                index1 = hm.get(target - numbers[i]);
                index2 = i + 1;
                break;
            }
        }
        return new int[]{index1, index2};
    }
}
