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
    public int maxLevelSum(TreeNode root) {
        int maxTotal = Integer.MIN_VALUE;
        int maxLayer = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int curLayer = 0;
        while (!q.isEmpty()){
            curLayer++;
            int size = q.size();
            int total = 0;
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                total += cur.val;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            if (total > maxTotal){
                maxTotal = total;
                maxLayer = curLayer;
            }
        }
        return maxLayer;
    }
}
//ACC