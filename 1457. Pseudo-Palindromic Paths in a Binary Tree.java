/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int total = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return total;
    }
    
    private void helper(TreeNode root, int count) {
        count ^= 1 << root.val;
        if (root.left == null && root.right == null) {
            total += isPalin(count) ? 1: 0; 
        } else if (root.left == null) {
            helper(root.right, count);
        } else if (root.right == null) {
            helper(root.left, count);
        } else {
            helper(root.right, count);
            helper(root.left, count);
        }
    }
    
    private boolean isPalin(int count) {
        int ones = 0;
        while (count > 0) {
            ones += count % 2;
            count /= 2;
        }
        return ones <= 1;
    }
}

// Runtime: 7 ms, faster than 83.35% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.
// Memory Usage: 57.9 MB, less than 100.00% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.