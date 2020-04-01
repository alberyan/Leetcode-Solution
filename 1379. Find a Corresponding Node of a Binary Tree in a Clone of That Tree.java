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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (right != null) return right;
        return null;
    }
}

// Runtime: 1 ms, faster than 50.00% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.
// Memory Usage: 44.7 MB, less than 100.00% of Java online submissions for Find a Corresponding Node of a Binary Tree in a Clone of That Tree.