/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node head = new Node(0);
        head.right = root;
        Node leftMin = treeToDoublyList(root.left);
        Node rightMin = treeToDoublyList(root.right);
        Node minMost = root;
        Node maxMost = root;
        if (leftMin != null){
            minMost = leftMin;
            Node leftMax = leftMin.left;
            head.right = leftMin;
            leftMax.right = root;
            root.left = leftMax;
        }
        if (rightMin != null){
            Node rightMax = rightMin.left;
            maxMost = rightMax;
            root.right = rightMin;
            rightMin.left = root;
        }
        minMost.left = maxMost;
        maxMost.right = minMost;
        return head.right;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.
// Memory Usage: 36.6 MB, less than 5.09% of Java online submissions for Convert Binary Search Tree to Sorted Doubly Linked List.