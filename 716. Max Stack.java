class MaxStack {
    class Node {
        Node pre;
        Node next;
        int val;
        boolean exist;
        int index;

        public Node(int val, int index){
            this.val = val;
            this.exist = true;
            this.index = index;
        }
    }

    PriorityQueue<Node> pq;
    Node top;
    int index;
    
    public MaxStack() {
        pq = new PriorityQueue<Node>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                if (n1.val == n2.val) return n2.index - n1.index;
                return n2.val - n1.val;
            }
        });
        Node dummy = new Node(0, -1);
        top = dummy;
        index = 0;
    }
    
    public void push(int x) {
        Node cur = new Node(x, index++);
        cur.pre = top;
        top.next = cur;
        pq.offer(cur);
        top = cur;
    }
    
    public int pop() {
        Node node = top;
        top = node.pre;
        top.next = null;
        node.exist = false;
        return node.val;
    }
    
    public int top() {
        return top.val;
    }
    
    public int peekMax() {
        popUntilExist();
        return pq.peek().val;
    }
    
    public int popMax() {
        popUntilExist();
        Node popNode = pq.poll();
        if (top == popNode){
            top = popNode.pre;
            top.next = null;
        } else {
            popNode.pre.next = popNode.next;
            popNode.next.pre = popNode.pre;
        }
        return popNode.val;
    }

    void popUntilExist(){
        while (!pq.peek().exist){
            pq.poll();
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

// Runtime: 55 ms, faster than 99.15% of Java online submissions for Max Stack.
// Memory Usage: 46.8 MB, less than 86.75% of Java online submissions for Max Stack.