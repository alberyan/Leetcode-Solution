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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        helper(root, res, 0);
        return res[0];
    }
    
    private void helper(TreeNode root, int[] res, int count) {
        if (root == null) return;
        int cur = count * 10 + root.val;
        if (root.left == null && root.right == null) {
            res[0] += cur;
            return;
        }
        helper(root.left, res, cur);
        helper(root.right, res, cur);
    }
}

// ACC