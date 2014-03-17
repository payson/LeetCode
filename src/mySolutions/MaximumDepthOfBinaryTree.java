package mySolutions;

import dataStructures.TreeNode;
/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Created by Payson Wu on 16/03/14.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
        }
    }
}
