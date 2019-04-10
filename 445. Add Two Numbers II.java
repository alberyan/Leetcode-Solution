/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0;
        ListNode cur1 = l1;
        while (cur1 != null){
            cur1 = cur1.next;
            len1++;
        }
        int len2 = 0;
        ListNode cur2 = l2;
        while (cur2 != null){
            cur2 = cur2.next;
            len2++;
        }
        if (len1 >= len2){
            return add(l1, l2, len1, len2);
        } else {
            return add(l2, l1, len2, len1);
        }
    }

    ListNode add(ListNode l1, ListNode l2, int len1, int len2){
        int[] arr = new int[len1];
        int dif = len1 - len2;
        for (int i = 0; i < len1; i++){
            arr[i] += l1.val;
            l1 = l1.next;
            if (dif <= 0){
                arr[i] += l2.val;
                l2 = l2.next;
            }
            dif--;
        }
        for (int i = len1 - 1; i >= 1; i--){
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        ListNode newNode = new ListNode(arr[0] / 10);
        ListNode head = newNode;
        arr[0] %= 10;
        for (int i = 0; i < len1; i++){
            newNode.next = new ListNode(arr[i]);
            newNode = newNode.next;
        }
        if (head.val == 0) head = head.next;
        return head;
    }
}

// Runtime: 2 ms, faster than 100.00% of Java online submissions for Add Two Numbers II.
// Memory Usage: 46.7 MB, less than 45.17% of Java online submissions for Add Two Numbers II.
