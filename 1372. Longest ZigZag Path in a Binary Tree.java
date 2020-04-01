/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxLength;
    
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        maxLength = 0;
        solve(root.right, true, 0);
        solve(root.left, false, 0);
        return maxLength;
    }
    
    private void solve(TreeNode root, boolean isRight, int count) {
        if (root == null) return;
        count++;
        maxLength = Math.max(maxLength, count);
        if (isRight) {
            solve(root.left, false, count);
            solve(root.right, true, 0);
        }
        else
        {
            solve(root.left, false, 0);
            solve(root.right, true, count);
        }
    }
}

// Runtime: 4 ms, faster than 100.00% of Java online submissions for Longest ZigZag Path in a Binary Tree.
// Memory Usage: 53.1 MB, less than 100.00% of Java online submissions for Longest ZigZag Path in a Binary Tree.