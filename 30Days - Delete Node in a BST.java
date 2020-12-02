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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            TreeNode node = findMin(root.right);
            root.val = node.val;
            root.right = deleteNode(root.right, node.val);
        }
        return root;
    }
    
    public TreeNode findMin(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
}

// ACC