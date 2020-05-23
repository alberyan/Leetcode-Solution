/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        while (head != null) {
            oddTail.next = head;
            head = head.next;
            oddTail = oddTail.next;
            oddTail.next = null;
            if (head != null) {
                evenTail.next = head;
                head = head.next;
                evenTail = evenTail.next;
                evenTail.next = null;
            }
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}

//ACC