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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        }
        addOneRow(root, v, d, 1);
        return root;
    }
    
    private void addOneRow(TreeNode root, int v, int d, int cur) {
        if (root == null) return;
        if (d == cur + 1) {
            TreeNode newLeft = new TreeNode(v);
            newLeft.left = root.left;
            root.left = newLeft;
            TreeNode newRight = new TreeNode(v);
            newRight.right = root.right;
            root.right = newRight;
            return;
        }
        addOneRow(root.left, v, d, cur + 1);
        addOneRow(root.right, v, d, cur + 1);
    }
    
}