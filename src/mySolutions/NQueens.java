package mySolutions;

import java.util.ArrayList;

/**
 * Created by Payson Wu on 22/03/14.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = -1;
        }
        putQueens(row, 0, result);
        return result;
    }
    private void putQueens(int[] row, int i, ArrayList<String[]> result) {
        if (i == row.length) {
            addSolution(row, result);
        }
        for (int k = 0; k < row.length; k++) {
            if (fit(row, i, k)) {
                row[i] = k;
                putQueens(row, i + 1, result);
            }
        }
    }
    private boolean fit(int[] row, int i, int j) { // row i, column j
        for (int k = 0; k < i; k++) {
            if (row[k] == j || Math.abs(k - i) == Math.abs(row[k] - j)) {
                return false;
            }
        }
        return true;
    }
    private void addSolution(int[] row, ArrayList<String[]> result) {
        String[] s = new String[row.length];
        for (int i = 0; i < row.length; i++) {
            s[i] = "";
            for (int j = 0; j < row.length; j++) {
                if (row[i] == j) {
                    s[i] += "Q";
                } else {
                    s[i] += ".";
                }
            }
        }
        result.add(s);
    }
}
