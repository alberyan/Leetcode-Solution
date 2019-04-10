/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    Random random;
    List<Integer> list;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

// Runtime: 54 ms, faster than 94.82% of Java online submissions for Linked List Random Node.
// Memory Usage: 40.7 MB, less than 52.75% of Java online submissions for Linked List Random Node.
