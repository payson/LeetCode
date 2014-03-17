package mySolutions;

/**
 * Created by Payson Wu on 16/03/14.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int result = A[0];
        for (int i = 1, f = A[0]; i < A.length; i++) {
            f = Math.max(A[i], f + A[i]);
            result = Math.max(f, result);
        }
        return result;
    }
}
