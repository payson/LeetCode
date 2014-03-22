package mySolutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Payson Wu on 22/03/14.
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 */
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) return result;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(num);
        comb(num, 0, 0, target, temp, result);
        return result;
    }
    private void comb(int[] candidates, int start, int sum, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        if (sum == target) {
            ArrayList<Integer> c = new ArrayList<Integer>(temp);
            if (!result.contains(c))
                result.add(c);
            return;
        }
        if (sum > target) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                comb(candidates, i+1, sum + candidates[i], target, temp, result);
                temp.remove(temp.size()-1);
            }
        }
    }
}
