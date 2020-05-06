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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode newRoot = new TreeNode(target);
        newRoot.left = root;
        helper(newRoot, target);
        return newRoot.left;
    }

    boolean helper(TreeNode root, int target) {
        if (root == null) return true;
        boolean noLeft = false;
        if (root.left == null || helper(root.left, target)) {
            noLeft = true;
            root.left = null;
        }
        boolean noRight = false;
        if (root.right == null || helper(root.right, target)) {
            noRight = true;
            root.right = null;
        }
        return root.val == target && noRight && noLeft;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Leaves With a Given Value.
// Memory Usage: 45.7 MB, less than 100.00% of Java online submissions for Delete Leaves With a Given Value.