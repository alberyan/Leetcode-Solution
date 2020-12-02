/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        else if (head.child == null) head.next = flatten(head.next);
        else{
            Node newNext = flatten(head.child);
            Node nextTail = newNext;
            while (nextTail.next != null){
                nextTail = nextTail.next;
            }
            nextTail.next = flatten(head.next);
            if (nextTail.next != null){
                nextTail.next.prev = nextTail;
            }
            head.next = newNext;
            newNext.prev = head;
            head.child = null;
        }
        return head;
    }
}

// ACC