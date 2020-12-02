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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerFirst(root);
        int layer = 0;
        while (!dq.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int size = dq.size();
            if (layer % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = dq.pollFirst();
                    if (node.left != null) {
                        dq.offerLast(node.left);
                    }
                    if (node.right != null) {
                        dq.offerLast(node.right);
                    }
                    cur.add(node.val);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = dq.pollLast();
                    if (node.right != null) {
                        dq.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        dq.offerFirst(node.left);
                    }
                    cur.add(node.val);
                }
            }
            res.add(cur);
            layer++;
        }
        return res;
    }
}

// ACC