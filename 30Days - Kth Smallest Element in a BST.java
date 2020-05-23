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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        scanTree(list, k, root);
        return list.get(k - 1);
    }
    
    private void scanTree(List<Integer> list, int k, TreeNode root) {
        if (root == null) return;
        if (list.size() >= k) return;
        scanTree(list, k, root.left);
        list.add(root.val);
        scanTree(list, k, root.right);
    }
}

//ACC