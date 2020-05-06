import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int res = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                res += curNode.val;
                if (curNode.left != null) q.offer(curNode.left);
                if (curNode.right != null) q.offer(curNode.right);
            }
            if (q.isEmpty()) return res;
        }
        return 0;
    }
}

// Runtime: 8 ms, faster than 7.69% of Java online submissions for Deepest Leaves Sum.
// Memory Usage: 49.4 MB, less than 100.00% of Java online submissions for Deepest Leaves Sum.

class Solution {
    int deepest = 0;
    int res = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int layer) {
        if (root == null) return;
        if (layer == deepest) res += root.val;
        if (layer > deepest) {
            res = root.val;
            deepest = layer;
        }
        dfs(root.left, layer + 1);
        dfs(root.right, layer + 1);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Deepest Leaves Sum.
// Memory Usage: 43.2 MB, less than 100.00% of Java online submissions for Deepest Leaves Sum.