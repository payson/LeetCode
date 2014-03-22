package mySolutions;

import java.util.ArrayList;

/**
 * This solution is not accepted... Time limit exceeds
 * Created by Payson Wu on 22/03/14.
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp = new ArrayList<String>();
        int length = s.length();
        boolean[][] table = new boolean[length][length];
        find(s, 0, result, temp, table);
        return result;
    }

    private void find(String s, int start, ArrayList<ArrayList<String>> result, ArrayList<String> temp, boolean[][] table) {
        int length = s.length();
        if (start == length && temp.size() != 0) {
            ArrayList<String> clone = temp;
            result.add(clone);
        } else {
            for (int j = start; j < length; j++) {
                if (j == start || (j - start == 1 && s.charAt(j) == s.charAt(start)) || (j - start > 1 && table[start+1][j-1])) {
                    table[start][j] = true;
                    temp.add(s.substring(start, j + 1));
                    find(s, j + 1, result, temp, table);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
