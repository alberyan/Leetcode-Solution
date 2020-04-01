class CustomStack {
    int[] increment;
    int[] stack;
    int pointer;

    public CustomStack(int maxSize) {
        increment = new int[maxSize];
        stack = new int[maxSize];
        pointer = 0;
    }
    
    public void push(int x) {
        if (pointer >= stack.length) return;
        stack[pointer] = x;
        increment[pointer] = 0;
        pointer++;
    }
    
    public int pop() {
        if (pointer == 0) return -1;
        pointer--;
        return stack[pointer] + increment[pointer];
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(pointer, k); i++){
            increment[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

// Runtime: 6 ms, faster than 88.83% of Java online submissions for Design a Stack With Increment Operation.
// Memory Usage: 41.9 MB, less than 100.00% of Java online submissions for Design a Stack With Increment Operation.