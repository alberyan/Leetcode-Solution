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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        solve(root, list);
        TreeNode newRoot = createTree(list, 0, list.size() - 1);
        return newRoot;
    }
    
    private void solve(TreeNode root, List<Integer> list){
        if (root == null) return;
        solve(root.left, list);
        list.add(root.val);
        solve(root.right, list);
    }
    
    private TreeNode createTree(List<Integer> list, int left, int right){
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = createTree(list, left, mid - 1);
        root.right = createTree(list, mid + 1, right);
        return root;
    }
}

// Runtime: 2 ms, faster than 99.77% of Java online submissions for Balance a Binary Search Tree.
// Memory Usage: 43.4 MB, less than 100.00% of Java online submissions for Balance a Binary Search Tree.