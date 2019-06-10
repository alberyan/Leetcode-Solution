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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        check(dummy, 0, limit);
        return dummy.left;
    }

    private void check(TreeNode node, int sumFromRoot, int limit){
    	if (node.left != null){
    		if (sumFromRoot + node.val + getMaxSum(node.left) < limit){
    			node.left = null;
    		} else {
    			check(node.left, sumFromRoot + node.val, limit);
    		}
    	}
    	if (node.right != null){
    		if (sumFromRoot + node.val + getMaxSum(node.right) < limit){
    			node.right = null;
    		} else {
    			check(node.right, sumFromRoot + node.val, limit);
    		}
    	}
    }

    private int getMaxSum(TreeNode node){
    	if (node.left == null && node.right == null){
    		return node.val;
    	} else if (node.left == null){
    		return node.val + getMaxSum(node.right);
    	} else if (node.right == null){
    		return node.val + getMaxSum(node.left);
    	} else {
    		return node.val + Math.max(getMaxSum(node.right), getMaxSum(node.left));
    	}
    }
}

// Runtime: 2 ms, faster than 23.68% of Java online submissions for Insufficient Nodes in Root to Leaf Paths.
// Memory Usage: 39.7 MB, less than 100.00% of Java online submissions for Insufficient Nodes in Root to Leaf Paths.