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
    public int countNodes(TreeNode root) {
    	if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
        	TreeNode cur = q.poll();
        	res++;
        	if (cur.left == null) return res + q.size();
        	q.offer(cur.left);
        	if (cur.right == null) return res + q.size();
        	q.offer(cur.right);
        }
        return res;
    }
}

//ACC