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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    
    private TreeNode helper(int post, int inS, int inE, int[] inorder, int[] postorder){
        if (post < 0 ||post > postorder.length - 1 || inS > inE){
            return null;
        }
        TreeNode root = new TreeNode(postorder[post]);
        int inIndex = 0;
        for (int i = inS; i <= inE; i++){
            if (inorder[i] == root.val){
                inIndex = i;
            }
        }
        root.left = helper(post - inE + inIndex - 1, inS, inIndex - 1, inorder, postorder);
        root.right = helper(post - 1, inIndex + 1, inE, inorder, postorder);
        return root;
    }
}

// ACC