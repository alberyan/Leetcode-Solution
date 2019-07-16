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
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0){
            return null;
        }
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode bstFromPreorder(int[] preorder, int startIndex, int endIndex) {
        if (startIndex >= preorder.length || startIndex > endIndex || endIndex >= preorder.length){
            return null;
        }
        int cur = preorder[startIndex];
        TreeNode curNode = new TreeNode(cur);
        
        int leftStart = startIndex + 1;
        if (leftStart > endIndex){
            return curNode;
        }
        int rightStart = -1;
        for (int i = leftStart; i <= endIndex; i++){
            if (preorder[i] > cur){
                rightStart = i;
                break;
            }
        } 
        if (rightStart == -1){
            curNode.left = bstFromPreorder(preorder, leftStart, endIndex);
        } else {
            curNode.left = bstFromPreorder(preorder, leftStart, rightStart - 1);
            curNode.right = bstFromPreorder(preorder, rightStart, endIndex);
        }
        
        return curNode;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
// Memory Usage: 35.7 MB, less than 99.79% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.