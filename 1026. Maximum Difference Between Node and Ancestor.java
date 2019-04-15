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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        int res = Math.max(maxDiff(root.left, root.val, root.val), maxDiff(root.right, root.val, root.val));
        return res;
    }

    int maxDiff(TreeNode root, int min, int max){
        if (root == null) return max - min;
        if (root.val < min) min = root.val;
        if (root.val > max) max = root.val;
        int left = maxDiff(root.left, min, max);
        int right = maxDiff(root.right, min, max);
        return Math.max(left, right);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Difference Between Node and Ancestor.
// Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Maximum Difference Between Node and Ancestor.
