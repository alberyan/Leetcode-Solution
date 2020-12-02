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
    int res;
    
    public int sumOfLeftLeaves(TreeNode root) {
        res = 0;
        if (root == null) return res;
        sumOfLeftLeaves(root.left, true);
        sumOfLeftLeaves(root.right, false);
        return res;
    }
    
    private void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (isLeft) {
                res += root.val;
            }
            return;
        }
        sumOfLeftLeaves(root.left, true);
        sumOfLeftLeaves(root.right, false);
    }
}

// ACC