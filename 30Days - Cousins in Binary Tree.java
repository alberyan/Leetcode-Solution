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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        int xDepth = depth(root, x);
        int yDepth = depth(root, y);
        if (xDepth != yDepth || xDepth == 0) {
            return false;
        }
        TreeNode xParent = parent(root, x);
        TreeNode yParent = parent(root, y);
        return xParent != yParent;
    }
    
    private TreeNode parent(TreeNode root, int x){
        if (root == null){
            return null;
        }
        if (root.left != null && root.left.val == x){
            return root;
        }
        if (root.right != null && root.right.val == x){
            return root;
        }
        TreeNode leftRes = parent(root.left, x);
        TreeNode rightRes = parent(root.right, x);
        return leftRes == null ? rightRes : leftRes;
    }
    
    private int depth(TreeNode root, int x){
        if (root == null){
            return 0;
        }
        if (root.val == x){
            return 1;
        }
        int curDepth = depth(root.left, x) + depth(root.right, x);
        return curDepth == 0 ? 0 : curDepth + 1;
    }
}

//ACC