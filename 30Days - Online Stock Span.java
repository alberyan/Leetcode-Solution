class StockSpanner {

    Deque<Integer> priceStack;
    Deque<Integer> countStack;
    
    public StockSpanner() {
        priceStack = new ArrayDeque<>();
        countStack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int count = 1;
        while (!priceStack.isEmpty() && priceStack.peekLast() <= price) {
            priceStack.pollLast();
            count += countStack.pollLast();
        }
        priceStack.offerLast(price);
        countStack.offerLast(count);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

 //ACC