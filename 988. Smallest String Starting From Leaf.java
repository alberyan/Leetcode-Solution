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
    PriorityQueue<String> pq;

    public String smallestFromLeaf(TreeNode root) {
        pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        createString(root, sb);
        return pq.peek();
    }

    void createString(TreeNode root, StringBuilder sb){
        sb.append((char)(root.val + 'a'));
        if (root.left == null && root.right == null){
            StringBuilder newSb = new StringBuilder(sb.toString());
            pq.offer(newSb.reverse().toString());
        }
        if (root.left != null){
            createString(root.left, sb);
        }
        if (root.right != null){
            createString(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}

// Runtime: 2 ms, faster than 97.59% of Java online submissions for Smallest String Starting From Leaf.
// Memory Usage: 38.1 MB, less than 10.92% of Java online submissions for Smallest String Starting From Leaf.
