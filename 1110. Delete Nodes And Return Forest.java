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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    	TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        Set<Integer> set = new HashSet<>();
        for (int i: to_delete){
        	set.add(i);
        }
        dummy.left = root;
        List<TreeNode> res = new ArrayList<>();
        res.add(dummy);
       	buildList(dummy, res, set);
       	trimTree(dummy, set);
       	res.remove(dummy);
       	if (dummy.left != null){
       		res.add(dummy.left);
       	}
       	return res;
    }

    void buildList(TreeNode root, List<TreeNode> res, Set<Integer> set){
    	if (root == null) return;
    	if (set.contains(root.val)){
    		if (root.left != null && !set.contains(root.left.val)){
    			res.add(root.left);
    		}
    		if (root.right != null && !set.contains(root.right.val)){
    			res.add(root.right);
    		}
    	}
    	buildList(root.left, res, set);
    	buildList(root.right, res, set);
    }

    void trimTree(TreeNode root, Set<Integer> set){
    	if (root == null) return;
    	trimTree(root.left, set);
    	trimTree(root.right, set);
    	if (root.left != null && set.contains(root.left.val)) root.left = null;
    	if (root.right != null && set.contains(root.right.val)) root.right = null;
    }
}

// Runtime: 3 ms, faster than 100.00% of Java online submissions for Delete Nodes And Return Forest.
// Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Delete Nodes And Return Forest.