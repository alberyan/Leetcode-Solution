class MinStack {
    Deque<Integer> dq;
    Deque<Integer> minDq;
    /** initialize your data structure here. */
    public MinStack() {
        dq = new ArrayDeque<>();
        minDq = new ArrayDeque<>();
    }
    
    public void push(int x) {
        dq.offerLast(x);
        if (minDq.isEmpty()) {
            minDq.offerLast(x);
        }
        else {
            minDq.offerLast(Math.min(x, minDq.peekLast()));
        }
        
    }
    
    public void pop() {
        dq.pollLast();
        minDq.pollLast();
    }
    
    public int top() {
        return dq.peekLast();
    }
    
    public int getMin() {
        return minDq.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */