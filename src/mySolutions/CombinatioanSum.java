package mySolutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Payson Wu on 22/03/14.
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
 */
public class CombinatioanSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        comb(candidates, 0, 0, target, result, temp);
        return result;
    }
    private void comb(int[] candidates, int start, int sum, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if (sum == target) {
            ArrayList<Integer> clone = new ArrayList<Integer>(temp);
            result.add(clone);
        } else if (sum > target) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                comb(candidates, i, sum + candidates[i], target, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
