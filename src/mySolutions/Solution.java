package mySolutions;
/**
 * Created by Payson Wu on 19/03/14.
 * Algorithms to find complementary pairs of numbers in an array
 *  The problem is to find in an array A of int values the number of all pairs of indices (i,j)
 *  so that A[i] + A[j] == K. For example, let A = { 1, 5, 9 } with K = 10
 *  we get the pairs (0, 2), (2,0), and (1,1) and the result of the algorithm should be 3.
 */


import java.util.HashMap;

public class Solution {
    public static int solution(int K, int[] A) {
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (hm.containsKey(A[i])) {
                hm.put(A[i], 1 + hm.get(A[i]));
            } else {
                hm.put(A[i], 1);
            }
        }
        for (int key : hm.keySet()) {
            if (hm.containsKey(K - key)) {
                int value1 = hm.get(key);
                int value2 = hm.get(K - key);
                result += value1 * value2;
            }
        }
        return result;
    }
}
