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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
       	Set<TreeNode> set = new HashSet<>();
       	set.add(root);
    	res.add(root.val);
       	if (root.left != null){
       		findLeftBoundary(res, set, root);
       	}
       	findLeaves(res, set, root);
       	if (root.right != null){
       		findRightBoundary(res, set, root);
       	}
       	return res;
    }

    void findLeftBoundary(List<Integer> res, Set<TreeNode> set, TreeNode root){
    	if (root == null) return;
    	if (!set.contains(root)){
    		set.add(root);
    		res.add(root.val);
    	}
    	if (root.left != null){
    		findLeftBoundary(res, set, root.left);
    	} else {
    		findLeftBoundary(res, set, root.right);
    	}
    }

    void findLeaves(List<Integer> res, Set<TreeNode> set, TreeNode root){
    	if (root == null) return;
    	if (root.left == null && root.right == null){
    		if (!set.contains(root)){
	    		set.add(root);
	    		res.add(root.val);
	    	}
    	} else {
    		findLeaves(res, set, root.left);
    		findLeaves(res, set, root.right);
    	}
    }

    void findRightBoundary(List<Integer> res, Set<TreeNode> set, TreeNode root){
    	if (root == null) return;
    	if (root.right != null){
    		findRightBoundary(res, set, root.right);
    	} else {
    		findRightBoundary(res, set, root.left);
    	}
    	if (!set.contains(root)){
    		set.add(root);
    		res.add(root.val);
    	}
    }
}

// Runtime: 2 ms, faster than 31.72% of Java online submissions for Boundary of Binary Tree.
// Memory Usage: 39.7 MB, less than 7.11% of Java online submissions for Boundary of Binary Tree.