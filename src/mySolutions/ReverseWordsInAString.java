package mySolutions;

/**
 * Created by Payson Wu on 17/03/14.
 *
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 click to show clarification.

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.equals("") || s == null) return "";
        char[] chars = s.toCharArray();

        // reverse the whole string
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }
        // reverse every word
        for (int i = 0, j = 0; i < s.length() && j <= s.length();) {
            if (j == s.length() || chars[j] == ' ') {
                int k = j - 1;
                while (i < k) {
                    swap(chars, i, k);
                    i++;
                    k--;
                }
                if (j == s.length()) {
                    break;
                } else {
                    i = ++j;
                }
            } else {
                j++;
            }
        }
        //better format
        StringBuilder sb = new StringBuilder();
        boolean inWord = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                if (!inWord) {
                    inWord = true;
                    sb.append(" ");
                }
                sb.append(chars[i]);
            } else {
                if (inWord) {
                    inWord = false;
                }
            }
        }
        return sb.toString().trim();
    }

    private void swap (char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
