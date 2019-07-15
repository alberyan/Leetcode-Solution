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
    double max;
    
    public double maximumAverageSubtree(TreeNode root) {
        max = Integer.MIN_VALUE;
        sumNode(root);
        return max;
    }
    
    private int[] sumNode(TreeNode root){
        if (root == null) return new int[]{0, 0};
        int[] left = sumNode(root.left);
        int[] right = sumNode(root.right);
        int sum = left[0] + right[0] + root.val;
        int node = left[1] + right[1] + 1;
        max = Math.max((sum + 0.0) / node, max);
        return new int[]{sum, node};
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Average Subtree.
// Memory Usage: 37.6 MB, less than 50.00% of Java online submissions for Maximum Average Subtree.