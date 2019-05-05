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
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        getGst(root, 0);
        return root;
    }

    int getGst(TreeNode root, int acc){
        if (root == null) return acc;
        int right = getGst(root.right, acc);
        root.val += right;
        int left = getGst(root.left, root.val);
        return left;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search Tree to Greater Sum Tree.
// Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Binary Search Tree to Greater Sum Tree.
