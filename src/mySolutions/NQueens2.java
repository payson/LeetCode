package mySolutions;

/**
 * Created by Payson Wu on 22/03/14.
 * Follow up for N-Queens problem.

 Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueens2 {
    private int result;
    public int totalNQueens(int n) {
        result = 0;
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = -1;
        }
        putQueens(row, 0);
        return this.result;
    }
    private void putQueens(int[] row, int i) {
        if (i == row.length) {
            this.result++;
            return;
        } else {
            for (int k = 0; k < row.length; k++) {
                if (fit(row, i, k)) {
                    row[i] = k;
                    putQueens(row, i + 1);
                }
            }
        }
    }
    private boolean fit(int[] row, int i, int j) { //row i column j
        for (int k = 0; k < i; k++) {
            if (row[k] == j || Math.abs(k - i) == Math.abs(row[k] - j)) {
                return false;
            }
        }
        return true;
    }
}
