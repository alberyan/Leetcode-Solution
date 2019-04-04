/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    class Node
    {
        int index;
        int value;
        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node x, Node y){
            return x.value - y.value;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        while (head != null){
            Node curNode = new Node(index, head.val);
            index++;
            head = head.next;
            list.add(0);
            while (!pq.isEmpty()){
                Node topNode = pq.peek();
                if (topNode.value < curNode.value){
                    topNode = pq.poll();
                    list.set(topNode.index, curNode.value);
                } else {
                    break;
                }
            }
            pq.offer(curNode);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }

}
