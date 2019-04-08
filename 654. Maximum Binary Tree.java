/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// O(height * n)
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    TreeNode construct(int[] nums, int start, int end){
        if (end < start) return null;
        int maxIndex = start;
        int curMax = nums[start];
        for (int i = start; i <= end; i++){
            if (nums[i] > curMax){
                maxIndex = i;
                curMax = nums[i];
            }
        }
        TreeNode root = new TreeNode(curMax);
        root.left = construct(nums, start, maxIndex - 1);
        root.right = construct(nums, maxIndex + 1, end);
        return root;
    }
}

// Runtime: 2 ms, faster than 100.00% of Java online submissions for Maximum Binary Tree.
// Memory Usage: 39.8 MB, less than 64.98% of Java online submissions for Maximum Binary Tree.
