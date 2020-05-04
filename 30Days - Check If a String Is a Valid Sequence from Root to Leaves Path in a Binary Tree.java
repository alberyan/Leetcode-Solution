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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }
    
    boolean isValid(TreeNode root, int[] arr, int index) {
        if (index == arr.length) {
            return false;
        }
        if (arr[index] == root.val) {
            if (root.left == null && root.right == null) return arr.length - 1 == index;
            if (root.left == null) return isValid(root.right, arr, index + 1);
            if (root.right == null) return isValid(root.left, arr, index + 1);
            return isValid(root.left, arr, index + 1) || isValid(root.right, arr, index + 1);
        }
        return false;
    }
}

//ACC