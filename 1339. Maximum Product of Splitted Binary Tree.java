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
    long total = 0;
    long res = 0;
    public int maxProduct(TreeNode root) {
        total = getSum(root);
        getSum(root);
        return (int)(res % (int)1000000007);
    }

    private int getSum(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val + getSum(root.left) + getSum(root.right);
        if (total > 0) {
            res = Math.max(res, sum * (total - sum));
        }
        return sum;
    }
}

// Runtime: 9 ms, faster than 71.49% of Java online submissions for Maximum Product of Splitted Binary Tree.
// Memory Usage: 57.4 MB, less than 100.00% of Java online submissions for Maximum Product of Splitted Binary Tree.