class ProductOfNumbers {
    Deque<Integer> dq;
    List<Integer> productList;

    public ProductOfNumbers() {
        dq = new ArrayDeque<>();
        productList = new LinkedList<>();
    }
    
    public void add(int num) {
        int size = productList.size();
        if (num == 0) {
            dq.offerLast(size);
            productList.add(0);
        }
        else if (size == 0 || productList.get(size - 1) == 0) {
            productList.add(num);
        }
        else {
            productList.add(productList.get(size - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = productList.size();
        int lastZero = -1;
        if (!dq.isEmpty()) {
            lastZero = dq.peekLast();
        }
        if (size - k <= lastZero) {
            return 0;
        }
        else if (size - k == lastZero + 1) {
            return productList.get(size - 1);
        }
        else {
            return productList.get(size - 1) / productList.get(size - k - 1);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

// Runtime: 15 ms, faster than 83.10% of Java online submissions for Product of the Last K Numbers.
// Memory Usage: 54.1 MB, less than 100.00% of Java online submissions for Product of the Last K Numbers.