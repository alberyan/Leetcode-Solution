/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (isSubPath(head, root.left)) return true;
        if (isSubPath(head, root.right)) return true;
        if (root.val == head.val) {
            if (isSubPath(head.next, root.left)) return true;
            if (isSubPath(head.next, root.right)) return true;
        }
        return false;
    }
}

// TLE

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}

// Runtime: 1 ms, faster than 99.47% of Java online submissions for Linked List in Binary Tree.
// Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Linked List in Binary Tree.