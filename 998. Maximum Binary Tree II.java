/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //O(height)
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        insert(root, val);
        return root;
    }

    void insert(TreeNode root, int val){
        if (root.right == null){
            root.right = new TreeNode(val);
            return;
        }
        if (root.right.val < val){
            TreeNode newRight = new TreeNode(val);
            newRight.left = root.right;
            root.right = newRight;
            return;
        }
        insert(root.right, val);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Binary Tree II.
// Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Maximum Binary Tree II.
