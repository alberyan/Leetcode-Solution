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
    public int pathSum(TreeNode root, int sum) {
        res = 0;
        int[] arr = new int[1000];
        helper(root, sum, arr, 0);
        return res;
    }
    
    private void helper(TreeNode root, int sum, int[] arr, int lastIndex) {
        if (root == null) return;
        for (int i = 0; i < lastIndex; i++) {
            arr[i] += root.val;
        }
        arr[lastIndex] = root.val;
        for (int i = 0; i <= lastIndex; i++) {
            if (arr[i] == sum) res++;
        }
        helper(root.left, sum, arr, lastIndex + 1);
        helper(root.right, sum, arr, lastIndex + 1);
        for (int i = 0; i < lastIndex; i++) {
            arr[i] -= root.val;
        }
    }
}

// Acc