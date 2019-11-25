/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    
    Set<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        if (root == null) return;
        root.val = 0;
        solve(root);
    }
    
    private void solve(TreeNode root) {
        set.add(root.val);
        if (root.left != null) {
            root.left.val = root.val * 2 + 1;
            solve(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 2;
            solve(root.right);
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

//Acc