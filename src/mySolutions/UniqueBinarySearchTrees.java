package mySolutions;

/**
 * Created by Payson Wu on 16/03/14.
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n < 2) return 1;
        int[] trees = new int[n+1];
        trees[0] = 1;
        trees[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp += trees[j] * trees[i-j-1];
            }
            trees[i] = temp;
        }
        return trees[n];
    }
}
