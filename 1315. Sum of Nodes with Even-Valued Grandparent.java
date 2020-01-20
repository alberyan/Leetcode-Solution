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
    int res;

    public int sumEvenGrandparent(TreeNode root) {
        res = 0;
        sumNode(root, false, false);
        return res;
    }

    private void sumNode(TreeNode root, boolean evenParent, boolean evenGrand) {
        if (root == null) return;
        if (evenGrand) res += root.val;
        boolean isEven = root.val % 2 == 0;
        sumNode(root.left, isEven, evenParent);
        sumNode(root.right, isEven, evenParent);
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
// Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.