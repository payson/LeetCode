package mySolutions;

/**
 * Created by Payson Wu on 22/03/14.
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioning2 {
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int length = s.length();
        int[] cut = new int[length+1];
        cut[length] = -1;
        boolean[][] isPalindrome = new boolean[length][length];

        for (int i = length - 1; i >= 0; i--) {
            cut[i] = Integer.MAX_VALUE;
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPalindrome[i+1][j-1])) {
                    isPalindrome[i][j] = true;
                    cut[i] = Math.min(cut[i], cut[j+1] + 1);
                }
            }
        }
        return cut[0];
    }
}
