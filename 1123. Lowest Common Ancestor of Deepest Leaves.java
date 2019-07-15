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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        Map<Integer, Queue<TreeNode>> map = new HashMap<>();
        mark(0, root, map);
        int maxDepth = 0;
        for (int i: map.keySet()){
            maxDepth = Math.max(i, maxDepth);
        }
        Queue<TreeNode> queue = map.get(maxDepth);
        while (queue.size() > 1){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            queue.offer(lca(root, node1, node2));
        }
        return queue.poll();
    }
    
    private void mark(int depth, TreeNode root, Map<Integer, Queue<TreeNode>> map){
        if (root == null) return;
        Queue<TreeNode> queue = map.getOrDefault(depth, new LinkedList<>());
        queue.offer(root);
        map.put(depth, queue);
        mark(depth + 1, root.left, map);
        mark(depth + 1, root.right, map);
    }
    
    private TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2){
        if (root == null) return null;
        if (root == n1 || root == n2) return root;
        TreeNode left = lca(root.left, n1, n2);
        TreeNode right = lca(root.right, n1, n2);
        if (left == null && right == null){
            return null;
        } else if (left == null){
            return right;
        } else if (right == null){
            return left;
        } else return root;
    }
}

// Runtime: 3 ms, faster than 50.00% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.
// Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Lowest Common Ancestor of Deepest Leaves.